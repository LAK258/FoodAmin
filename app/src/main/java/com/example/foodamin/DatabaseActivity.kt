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

//        val db = Room.databaseBuilder(applicationContext, FoodDatabase::class.java, "Food")
//            .createFromAsset("databases/Food.sql")
//            .allowMainThreadQueries()
//            .fallbackToDestructiveMigration()
//            .build()
//
//        val foodDao = db.foodDao()
//
//        println("------------------------------------------------------------------------")
//        println(db)
//        //val accessedDatabase = db.openHelper.writableDatabase
//        val test = foodDao.getAll()
//

        binding.button.setOnClickListener {
            //db.FoodDao().insertAll(Food("hej","hejs",1,"he","er",3,"se","er"))


        }



    }
}