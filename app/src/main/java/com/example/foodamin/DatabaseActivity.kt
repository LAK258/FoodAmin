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

        // databases are made in all classes only due to time restrictions
        supportActionBar?.hide()

        val vitaminDB = Room.databaseBuilder(applicationContext,FoodDatabase::class.java,"VitaminFinalDB")
            .createFromAsset("databases/Vitamins.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        val vitaminID = intent.getIntExtra("vitaminID", 0)  // finds the vitamin id
        val vitaminProduct = vitaminDB.VitaminsDao().findItemVitamin(vitaminID) // finds the specific vitamin bottle

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

        // button interactions
        binding.scanAfterScanBtn.setOnClickListener {
            val scanActivity = Intent(this, BarcodeScanningActivity::class.java)
            startActivity(scanActivity)
        }
        binding.compareWithfoodAfterScanBtn.setOnClickListener{
            val compareActivity = Intent(this, ComparisonActivity::class.java).apply {
                putExtra("vitaminID", vitaminID)
            }
            startActivity(compareActivity)
        }
        binding.foodContainingAfterScanBtn.setOnClickListener {
            val foodsWithVitamins = Intent(this, FoodWithVitaminsActvity::class.java).apply {
                putExtra("vitaminID", vitaminID)
                putExtra("originalPage", 1)
            }
            startActivity(foodsWithVitamins)
        }

        binding.backBtn2.setOnClickListener {
            val previousPage = Intent (this, BarcodeScanningActivity::class.java)
            startActivity(previousPage)
        }
    }
}