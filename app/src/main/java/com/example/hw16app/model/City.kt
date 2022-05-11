package com.example.hw16app.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class City(@PrimaryKey val id: Int, var name: String, var isFavorite: Boolean)