package com.example.hw16app.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.hw16app.model.City
import com.example.hw16app.model.FavoriteCity

@Dao
interface CityDao {

    @Query("SELECT * FROM City")
    fun getAllCities(): LiveData<List<City>>

    @Query("SELECT * FROM FavoriteCity")
    fun getAllFavoriteCities(): LiveData<List<FavoriteCity>>

    @Insert
    fun insertAllCities(city: List<City>)

    @Insert
    fun insertAllFavoriteCity(vararg facoriteCity: FavoriteCity)

    @Delete
    fun delete(vararg favoriteCity: FavoriteCity)
}