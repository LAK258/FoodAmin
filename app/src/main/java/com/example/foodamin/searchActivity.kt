package com.example.foodamin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.foodamin.adapter.ItemAdapter
import com.example.foodamin.databinding.ActivitySearchBinding

class searchActivity : AppCompatActivity() {

    lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val foodDB = Room.databaseBuilder(applicationContext,FoodDatabase::class.java,"foodFinalDB")
            .createFromAsset("databases/Food1.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
        val myData = foodDB.foodDao().getAll()

        val recyclerView = findViewById<RecyclerView>()
        recyclerView.adapter = ItemAdapter(this, myData)    }
}