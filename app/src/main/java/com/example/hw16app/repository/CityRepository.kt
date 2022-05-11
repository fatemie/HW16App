package com.example.hw16app.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.hw16app.database.AppDatabase
import com.example.hw16app.database.CityDao
import com.example.hw16app.model.City
import com.example.hw16app.model.FavoriteCity

object CityRepository {
    var cityList = listOf(City(1,"تهران", false),
        City(2,"اصفهان", false),
        City(3,"مشهد", false),
        City(4,"تبریز", false),
        City(5,"کرج", false),
        City(6,"رشت", false),
        City(7,"قم", false),
        City(8,"اردبیل", false),
        City(9,"قزوین", false),
        City(10,"بوشهر", false))

    var db: AppDatabase?=null
    var dao: CityDao?=null

    fun initDB(context: Context){
        db= AppDatabase.getAppDatabase(context)
        dao=db?.cityDao()
    }
    init {
        insertCity(cityList)
    }


    fun insertCity(city: List<City>){
        dao?.insertAllCities(city)
    }

    fun insertFavoriteCity( favoriteCity: FavoriteCity){
        dao?.insertAllFavoriteCity(favoriteCity)
    }

    fun getAllCities() : LiveData<List<City>>? {
        return dao?.getAllCities()
    }

    fun getAllFavoriteCities() : LiveData<List<FavoriteCity>>? {
        return dao?.getAllFavoriteCities()
    }

    fun deleteCity(favoriteCity: FavoriteCity){
        dao?.delete(favoriteCity)
    }
}