package com.example.hw16app.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.hw16app.model.City
import com.example.hw16app.model.FavoriteCity

@Dao
interface CityDao {

    @Query("SELECT * FROM City")
    fun getAllCities(): List<City>

    @Query("SELECT * FROM FavoriteCity")
    fun getAllFavoriteCities(): LiveData<List<FavoriteCity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCities(city: City)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllFavoriteCity(vararg favoriteCity: FavoriteCity)

    @Delete
    fun delete(vararg favoriteCity: FavoriteCity)
}