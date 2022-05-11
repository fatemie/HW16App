package com.example.hw16app.database

import com.example.hw16app.model.City
import com.example.hw16app.model.FavoriteCity
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [City::class, FavoriteCity::class], version = 1 )
abstract class AppDatabase : RoomDatabase(){
    abstract fun cityDao(): CityDao

    companion object{
        var instance : AppDatabase?=null
        fun getAppDatabase(context: Context):AppDatabase?{
            if (instance==null) {
                synchronized(AppDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "CityDB"
                    )
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return instance
        }
    }
}