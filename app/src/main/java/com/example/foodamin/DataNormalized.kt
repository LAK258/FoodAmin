package com.example.foodamin

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataNormalized (
    @PrimaryKey val id: Int,
)