package com.example.foodamin

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Vitamins (

    @PrimaryKey var Barcode: Long,

    var VitaminName: String?,

    var DVitamin: Int?,

    var AVitamin: Int?,

    var CVitamin: Int?,

    var B12Vitamin: Int?,

    var B6Vitamin: Int?,

    var Thiamin: Int?,

    var EVitamin: Int?,

    var Riboflavin: Int?,

    var Niacin: Int?,

    var Folsyre: Int?,

    var Biotin: Int?,

    var Panthothensyre: Int?,

)