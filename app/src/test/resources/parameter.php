<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "food_database";
 
// connect with database demo
$conn = new mysqli($servername, $username, $password, $dbname);
 
 // an array to display response
 $response = array();
 // on below line we are checking if the parameter send is id or not.
 if($_POST['ParameterNavn']){
     // if the parameter send from the user id id then
     // we will search the item for specific id.
     $ParameterNavn = $_POST['ParameterNavn'];
        //on below line we are selecting the course detail with below id.
     $stmt = $conn->prepare("SELECT ParameterNavn,ParameterName,Unit,SortKey,ParameterID,EuroFIR_Code,EFSA_PARAM_Code,ParameterGroupID,ParameterGruppeNavn,ParameterGroupName FROM parameter WHERE ParameterNavn = ?");
     $stmt->bind_param("s",$ParameterNavn);
     $result = $stmt->execute();
   // on below line we are checking if our
   // table is having data with specific id.
   if($result == TRUE){
         // if we get the response then we are displaying it below.
         $response['error'] = false;
         $response['message'] = "Retrieval Successful!";
         // on below line we are getting our result.
         $stmt->store_result();
         // on below line we are passing parameters which we want to get.
         $stmt->bind_result($ParameterNavn,$ParameterName,$Unit,$SortKey,$ParameterID,$EuroFIR_Code,$EFSA_PARAM_Code,$ParameterGroupID,$ParameterGruppeNavn,$ParameterGroupName);
         // on below line we are fetching the data.
         $stmt->fetch();
         // after getting all data we are passing this data in our array.
         $response['ParameterNavn'] = $ParameterNavn;
         $response['ParameterName'] = $ParameterName;
         $response['Unit'] = $Unit;
         $response['SortKey'] = $SortKey;
         $response['ParameterID'] = $ParameterID;
         $response['EuroFIR_Code'] = $EuroFIR_Code;
         $response['EFSA_PARAM_Code'] = $EFSA_PARAM_Code;
         $response['ParameterGroupID'] = $ParameterGroupID;
         $response['ParameterGruppeNavn'] = $ParameterGruppeNavn;
         $response['ParameterGroupName'] = $ParameterGroupName;
     } else{
         // if the id entered by user donot exist then
         // we are displaying the error message
         $response['error'] = true;
         $response['message'] = "Incorrect id";
     }
 } else{
      // if the user donot adds any parameter while making request
      // then we are displaying the error as insufficient parameters.
      $response['error'] = true;
      $response['message'] = "Insufficient Parameters";
 }
 // at last we are printing
 // all the data on below line.
 echo json_encode($response);
?>