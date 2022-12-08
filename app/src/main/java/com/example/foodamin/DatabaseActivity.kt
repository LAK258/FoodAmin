package com.example.foodamin

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

        var foodDB = Room.databaseBuilder(applicationContext,FoodDatabase::class.java,"FoodDB")
            .createFromAsset("databases/Food.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        var vitaminDB = Room.databaseBuilder(applicationContext,FoodDatabase::class.java,"VitaminDB")
            .createFromAsset("databases/Vitamins.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()


        val foodDao = foodDB.foodDao().getAll()
        val vitaminsDao = vitaminDB.VitaminsDao().getAll()

//        val test = intent.getStringArrayExtra("Test",)


        binding.button.setOnClickListener {

 //           Toast.makeText(this,"$test", Toast.LENGTH_LONG).show()
        }



    }
}