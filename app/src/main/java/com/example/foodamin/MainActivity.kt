package com.example.foodamin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodamin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding // creates a variable to be initialized later

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // connects the binding variable to the layout file
        setContentView(binding.root) // set which layout file to view


        binding.find.setOnClickListener { //if no bottle available
            val database = Intent(this, DatabaseActivity::class.java).apply {
                putExtra("vitaminID", 38)
            }
            startActivity(database)
        }
        binding.btn.setOnClickListener{
            val barcodeScanning = Intent(this, BarcodeScanningActivity::class.java)
            startActivity(barcodeScanning)


        }
    }
}