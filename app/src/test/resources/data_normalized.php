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
 if($_POST['FoodID']){
     // if the parameter send from the user id id then
     // we will search the item for specific id.
     $FoodID = $_POST['FoodID'];
        //on below line we are selecting the course detail with below id.
     $stmt = $conn->prepare("SELECT FoodID,FoedevareNavn,FoodName,ParameterID,ParameterNavn,ParameterName,SortKey,ResVal,Source,SourceFood FROM data_normalized WHERE FoodID = ?");
     $stmt->bind_param("s",$FoodID);
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
         $stmt->bind_result($FoodID,$FoedevareNavn,$FoodName,$ParameterID,$ParameterNavn,$ParameterName,$SortKey,$ResVal,$Source,$SourceFood);
         // on below line we are fetching the data.
         $stmt->fetch();
         // after getting all data we are passing this data in our array.
         $response['FoodID'] = $FoodID;
         $response['FoedevareNavn'] = $FoedevareNavn;
         $response['FoodName'] = $FoodName;
         $response['ParameterID'] = $ParameterID;
         $response['ParameterNavn'] = $ParameterNavn;
         $response['ParameterName'] = $ParameterName;
         $response['SortKey'] = $SortKey;
         $response['ResVal'] = $ResVal;
         $response['Source'] = $Source;
         $response['SourceFood'] = $SourceFood;

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