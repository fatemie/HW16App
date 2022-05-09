package com.example.hw16app.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.hw16app.model.City
import com.example.hw16app.repository.CityRepository

class CityViewModel(app: Application) : AndroidViewModel(app) {
    var cityList = arrayListOf<City>()
    var favoriteList = arrayListOf<City>()

    init {
        cityList = CityRepository.cityList
    }

    fun onCityClicked(city:City){
        if(!city.isFavorite){
            favoriteList.add(city)
        }else{
            favoriteList.remove(city)
        }
    }
}