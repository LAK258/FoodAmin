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

        var db = Room.databaseBuilder(applicationContext,FoodDatabase::class.java,"Foodtest11")
            .createFromAsset("databases/Food.sql")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        binding.btn.setOnClickListener{
            val barcodeScanning = Intent(this, BarcodeScanningActivity::class.java)
            startActivity(barcodeScanning)
        }

        binding.btn2.setOnClickListener{

            Toast.makeText(this, "${db.foodDao().getAll()}", Toast.LENGTH_LONG).show()
//              val database = Intent(this, DatabaseActivity::class.java)
//              startActivity(database)
        }
    }
}