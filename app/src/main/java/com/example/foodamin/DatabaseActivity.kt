package com.example.foodamin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.foodamin.databinding.ActivityDatabaseBinding


class DatabaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDatabaseBinding // creates a variable to be initialized later


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatabaseBinding.inflate(layoutInflater) // connects the binding variable to the layout file
        setContentView(binding.root) // set which layout file to view


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
        val foodsWithVitamins = foodDB.foodDao().findItemVitamin(vitaminProduct[0].ParameterID) // finds all items containing the vitamin bottles' vitamin and sorts them in descending order in a list. this will not be used in the test version

        //setup Layout text
        binding.vitaminNameAfterScan.text = vitaminProduct[0].Vitamin
        binding.vitaminBrandAfterScan.text = vitaminProduct[0].VitaminProduct

        val tableDescription = "Amount of ${vitaminProduct[0].Vitamin} in 1 pill"
        binding.amountOfVitaminAfterScan.text = tableDescription
        val fullRIString = "${vitaminProduct[0].RI} ${vitaminProduct[0].Unit}" // set and create function textCreator
        binding.AmountFullRiAfterScan.text = fullRIString
        val amountString = "${vitaminProduct[0].Contains} ${vitaminProduct[0].Unit}" // set in function textCreator
        binding.AmountInPillAfterScan.text = amountString
        val percentageCalc = "${vitaminProduct[0].Contains/ vitaminProduct[0].RI!!*100}%RI" // set in function textCreator
        binding.pillRiAfterScan.text = percentageCalc

        binding.compareWithfoodAfterScanBtn.setOnClickListener{
            val compareActivity = Intent(this, ComparisonActivity::class.java)
            startActivity(compareActivity)
        }
    }
}