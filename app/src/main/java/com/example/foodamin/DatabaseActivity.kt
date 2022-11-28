package com.example.foodamin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodamin.databinding.ActivityDatabaseBinding


class DatabaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDatabaseBinding // creates a variable to be initialized later


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            ActivityDatabaseBinding.inflate(layoutInflater) // connects the binding variable to the layout file
        setContentView(binding.root) // set which layout file to view

        binding.button.setOnClickListener {


        }



    }
}