package com.example.foodamin

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FoodDao {
    @Query("SELECT * FROM Food")
    fun getAll(): List<Food>

    @Query("SELECT * FROM Food WHERE ParameterID = :vitaminID AND ResVal > 0 ORDER BY ResVal DESC")
    fun findItemVitamin(vitaminID: Int): List<Food>

    @Query("SELECT * FROM Food where FoodName = :nameOfFood")
    fun usabilityTestQuery(nameOfFood: String): List<Food>

    @Insert
    fun insertAll(vararg foods: Food)

}