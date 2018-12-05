package com.avukelic.weatherapp

import android.app.Application
import com.avukelic.weatherapp.networking.RetrofitUtil
import com.avukelic.weatherapp.networking.WeatherApiService
import retrofit2.Retrofit

class App : Application() {

    companion object {
        val weatherApiService = RetrofitUtil.createRetrofit().create(WeatherApiService::class.java)
    }

    override fun onCreate() {
        super.onCreate()
    }
}