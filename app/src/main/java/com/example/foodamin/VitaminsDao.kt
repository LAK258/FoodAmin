package com.example.foodamin

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface VitaminsDao {

    @Query("SELECT * FROM Vitamins")
    fun getAll(): List<Vitamins>

    @Query("SELECT ParameterID FROM Vitamins WHERE Barcode = :scannedValue")
    fun findItemFromCode(scannedValue: String): Int

    @Query("SELECT * FROM Vitamins WHERE ParameterID = :vitaminID")
    fun findItemVitamin(vitaminID: Int): List<Vitamins>

    @Insert
    fun insertAll(vararg vitamins: Vitamins)

}