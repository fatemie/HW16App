package com.example.hw16app.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class City(@PrimaryKey(autoGenerate = true) val id: Int, val name: String, var isFavorite: Boolean)