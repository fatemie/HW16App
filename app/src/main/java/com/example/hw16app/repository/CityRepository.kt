package com.example.hw16app.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.hw16app.database.AppDatabase
import com.example.hw16app.database.CityDao
import com.example.hw16app.model.City
import com.example.hw16app.model.FavoriteCity

object CityRepository {
   lateinit var cityList : List<City>
    val city1 = City(1,"تهران", false)
    val city2 =City(2,"اصفهان", false)
    val city3 =City(3,"مشهد", false)
    val city4 =City(4,"تبریز", false)
    val city5 =City(5,"کرج", false)
    val city6 =City(6,"رشت", false)
    val city7 =City(7,"قم", false)
    val city8 =City(8,"اردبیل", false)
    val city9 =City(9,"قزوین", false)
    val city10 =City(10,"بوشهر", false)

    var db: AppDatabase?=null
    var dao: CityDao?=null

    fun initDB(context: Context){
        db= AppDatabase.getAppDatabase(context)
        dao=db?.cityDao()
    }

    fun addData(){
        insertCity(city1)
        insertCity(city2)
        insertCity(city3)
        insertCity(city4)
        insertCity(city5)
        insertCity(city6)
        insertCity(city7)
        insertCity(city8)
        insertCity(city9)
        insertCity(city10)
    }


    fun insertCity(city: City){
        dao?.insertAllCities(city)
    }

    fun insertFavoriteCity( favoriteCity: FavoriteCity){
        dao?.insertAllFavoriteCity(favoriteCity)
    }

    fun getAllCities() : List<City>? {
        return dao?.getAllCities()
    }

    fun getAllFavoriteCities() : LiveData<List<FavoriteCity>>? {
        return dao?.getAllFavoriteCities()
    }

    fun deleteCity(favoriteCity: FavoriteCity){
        dao?.delete(favoriteCity)
    }
}