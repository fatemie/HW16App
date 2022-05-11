package com.example.hw16app.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.hw16app.model.City
import com.example.hw16app.model.FavoriteCity
import com.example.hw16app.repository.CityRepository

class CityViewModel(app: Application) : AndroidViewModel(app) {
    lateinit var cityList : List<City>
    var favoriteList = arrayListOf<City>()

    init {
        CityRepository.initDB(app.applicationContext)
        cityList = CityRepository.cityList
    }


    fun addCity(city: List<City>) {
        CityRepository.insertCity(city)
    }

    fun addFavoriteCity(city: FavoriteCity) {
        CityRepository.insertFavoriteCity(city)
    }

    fun deleteCity(favoriteCity: FavoriteCity) {
        CityRepository.deleteCity(favoriteCity)
    }

    fun getAllCities(): LiveData<List<City>>? {
        return CityRepository.getAllCities()
    }

    fun getAllFavoriteCities(): LiveData<List<FavoriteCity>>? {
        return CityRepository.getAllFavoriteCities()
    }

    fun onCityClicked(city:City){
        if(!city.isFavorite){
            favoriteList.add(city)
            city.isFavorite = true
        }else{
            favoriteList.remove(city)
            city.isFavorite = false
        }
    }
}