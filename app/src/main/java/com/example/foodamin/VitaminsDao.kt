package com.example.foodamin

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface VitaminsDao {

    @Query("SELECT * FROM Vitamins")
    fun getAll(): List<Vitamins>

    @Insert
    fun insertAll(vararg vitamins: Vitamins)

}