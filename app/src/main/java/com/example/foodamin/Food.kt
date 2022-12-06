package com.example.foodamin

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Food (

    var FoedevareNavn: String?,

    var FoodName: String?,

    @PrimaryKey var FoodID: Int,

    var EnergiKcal: Int?,

    var Avitamin: Int?,

    var Dvitamin: Int?,

    var D3vitamin: Int?,

    var D2vitamin: Int?,

    var hydroxyD3vitamin: Int?,

    var hydroxyD2vitamin: Int?,

    var Evitamin: Int?,

    var K1vitamin: Int?,

    var ThiaminB1vitamin: Int?,

    var Thiamin: Int?,

    var hydroxyethylthiamin: Int?,

    var RiboflavinB2vitamin: Int?,

    var Niacinaekvivalent: Int?,

    var Niacin: Int?,

    var B6vitamin: Int?,

    var Pantothensyre: Int?,

    var Biotin: Int?,

    var Folat: Int?,

    var Fritfolat: Int?,

    var B12vitamin: Int?,

    var Cvitamin: Int?,
    )