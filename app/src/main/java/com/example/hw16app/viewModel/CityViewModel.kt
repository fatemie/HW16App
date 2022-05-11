package com.example.hw16app.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.hw16app.model.City
import com.example.hw16app.model.FavoriteCity
import com.example.hw16app.repository.CityRepository

class CityViewModel(app: Application) : AndroidViewModel(app) {
    lateinit var cityList : List<City>
    lateinit var favoriteList : LiveData<List<FavoriteCity>>

    init {
        CityRepository.initDB(app.applicationContext)
        cityList = CityRepository.getAllCities()!!
        if(cityList.isEmpty()){
            CityRepository.addData()
            cityList = CityRepository.getAllCities()!!
        }
        favoriteList = CityRepository.getAllFavoriteCities()!!
    }


    fun addCity(city: City) {
        CityRepository.insertCity(city)
    }

    fun addFavoriteCity(city: FavoriteCity) {
        CityRepository.insertFavoriteCity(city)
    }

    fun deleteCity(favoriteCity: FavoriteCity) {
        CityRepository.deleteCity(favoriteCity)
    }

    fun getAllCities(): List<City>? {
        return CityRepository.getAllCities()
    }

    fun getAllFavoriteCities(): LiveData<List<FavoriteCity>>? {
        return CityRepository.getAllFavoriteCities()
    }

    fun onCityClicked(city:City){
        val favoriteCity = FavoriteCity(city.id, city.name )
        if(!city.isFavorite){
            //favoriteList.add(city)
                addFavoriteCity(favoriteCity)
            city.isFavorite = true
        }else{
            //favoriteList.remove(city)
                deleteCity(favoriteCity)
            city.isFavorite = false
        }
        CityRepository.insertCity(city)
    }
}