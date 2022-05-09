package com.example.hw16app.repository

import com.example.hw16app.model.City

object CityRepository {
    var cityList = arrayListOf<City>()
    init {
        cityList.add(City("تهران", false))
        cityList.add(City("اصفهان", false))
        cityList.add(City("مشهد", false))
        cityList.add(City("تبریز", false))
        cityList.add(City("کرج", false))
        cityList.add(City("رشت", false))
        cityList.add(City("قم", false))
        cityList.add(City("اردبیل", false))
        cityList.add(City("قزوین", false))
        cityList.add(City("بوشهر", false))
    }
}