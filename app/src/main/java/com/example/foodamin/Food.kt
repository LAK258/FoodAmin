package com.example.foodamin

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Food (

    @ColumnInfo(name ="FoedevareNavn")
    var FoedevareNavn: String?,

    @ColumnInfo (name ="FoodName")
    var FoodName: String?,

    @PrimaryKey var FoodID: Int,

    @ColumnInfo (name ="Taxonomi")
    var Taxonomi: String?,

    @ColumnInfo (name ="FoodEx2Code")
    var FoodEx2Code: String?,

    @ColumnInfo (name ="FoodGroupID")
    var FoodGroupID: Int?,

    @ColumnInfo (name ="FoedevareGruppe")
    var FoedevareGruppe: String?,

    @ColumnInfo (name ="FoodGroup")
    var FoodGroup: String?,

    )