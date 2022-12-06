package com.example.foodamin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.foodamin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding // creates a variable to be initialized later

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // connects the binding variable to the layout file
        setContentView(binding.root) // set which layout file to view

        var foodDB = Room.databaseBuilder(applicationContext,FoodDatabase::class.java,"Foodtest21")
            .createFromAsset("databases/Food.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        var vitaminDB = Room.databaseBuilder(applicationContext,FoodDatabase::class.java,"Foodtest22")
            .createFromAsset("databases/Vitamins.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()


        val foodDao = foodDB.foodDao().getAll()
        val vitaminsDao = vitaminDB.VitaminsDao().getAll()

        binding.btn.setOnClickListener{
            val barcodeScanning = Intent(this, BarcodeScanningActivity::class.java)
            startActivity(barcodeScanning)
        }

        binding.btn2.setOnClickListener{

            Toast.makeText(this, "${vitaminsDao[0].Barcode}", Toast.LENGTH_LONG).show()
//              val database = Intent(this, DatabaseActivity::class.java)
//              startActivity(database)
        }
    }
}