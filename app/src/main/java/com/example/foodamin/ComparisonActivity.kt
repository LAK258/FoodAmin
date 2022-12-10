package com.example.foodamin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.foodamin.databinding.ActivityComparisonBinding

class ComparisonActivity : AppCompatActivity() {

    lateinit var binding: ActivityComparisonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComparisonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // databases are made in all classes only due to time restrictions

        val foodDB = Room.databaseBuilder(applicationContext,FoodDatabase::class.java,"foodFinalDB")
            .createFromAsset("databases/Food1.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        val vitaminDB = Room.databaseBuilder(applicationContext,FoodDatabase::class.java,"VitaminFinalDB")
            .createFromAsset("databases/Vitamins.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        val vitaminID = intent.getIntExtra("vitaminID", 0)  // finds the vitamin id
        val vitaminProduct = vitaminDB.VitaminsDao().findItemVitamin(vitaminID) // finds the specific vitamin bottle
        //val foodsWithVitamins = foodDB.foodDao().findItemVitamin(vitaminProduct[0].ParameterID) // finds all items containing the vitamin bottles' vitamin and sorts them in descending order in a list. this will not be used in the test version
        val bellPepper = foodDB.foodDao().usabilityTestQuery("Pepper, sweet, red, raw")

        //layout
            //
        val foodComparisonName = "1 ${bellPepper[0].FoodName}"
        binding.foodNameComparison.text = foodComparisonName

        binding.foodNameComparison.text = bellPepper[0].FoodName

        val foodAmountGramsString = "${bellPepper[0].ResVal?.toInt()} ${vitaminProduct[0].Unit}" // set in function textCreator
        binding.foodGramsComparison.text = foodAmountGramsString

        val bellPepperValueInt= bellPepper[0].ResVal!!/ vitaminProduct[0].RI!!*100
        val foodPercentageRiPillCalc = "${bellPepperValueInt.toInt()}%RI" // set in function textCreator
        binding.foodRiComparison.text = foodPercentageRiPillCalc

            //vitamin
        binding.vitaminNameComparison.text = vitaminProduct[0].Vitamin
        val amountGramsString = "${vitaminProduct[0].Contains} ${vitaminProduct[0].Unit}" // set in function textCreator
        binding.pillGramsComparison.text = amountGramsString
        val percentageRiPillCalc = "${vitaminProduct[0].Contains/ vitaminProduct[0].RI!!*100}%RI" // set in function textCreator
        binding.pillRiPercentageComparison.text = percentageRiPillCalc

        // button interactions
        binding.scanComparisonBtn.setOnClickListener {
            val scanActivity = Intent(this, BarcodeScanningActivity::class.java)
            startActivity(scanActivity)
        }
        binding.foodWithVitaminComparisonBtn.setOnClickListener {
            val foodsWithVitamins = Intent(this, FoodWithVitaminsActvity::class.java)
            startActivity(foodsWithVitamins)
        }
    }
}