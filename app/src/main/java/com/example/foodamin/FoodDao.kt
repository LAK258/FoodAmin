package com.example.foodamin

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FoodDao {
    @Query("SELECT * FROM Food")
    fun getAll(): List<Food>

//    @Query("SELECT * FROM Food WHERE FoodID = 1")
//    fun getF(): List<Food>

    @Insert
    fun insertAll(vararg foods: Food)

}