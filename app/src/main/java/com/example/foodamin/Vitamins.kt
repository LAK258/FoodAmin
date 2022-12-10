package com.example.foodamin

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity
data class Vitamins (

    @PrimaryKey
    var IndexID: Int,

    var Barcode: Long,

    var VitaminProduct: String,

    var Vitamin: String,

    var Unit: String,

    var RI: Int?,

    var SourceID: Int,

    var Contains: Int,

    var ParameterID: Int,

    )