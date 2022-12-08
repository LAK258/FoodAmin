package com.example.foodamin

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Food (

    @PrimaryKey var TableIndex: Int,

    var FoodID: Int?,

    var FoedevareNavn : String?,

    var FoodName: String?,

    var ParameterID: Int,

    var ParameterNavn: String?,

    var ParameterName: String?,

    var ResVal: Float?,

    )