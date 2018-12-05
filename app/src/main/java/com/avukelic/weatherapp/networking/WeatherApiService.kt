package com.avukelic.weatherapp.networking

import com.avukelic.weatherapp.model.ForecastResponse
import com.avukelic.weatherapp.model.WeatherResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("data/2.5/weather")
    fun getWeather(@Query("appid") apiKey: String, @Query("q") city: String, @Query("units") units: String): Single<WeatherResponse>

    @GET("/data/2.5/forecast")
    fun getForecast(@Query("appid") apiKey: String, @Query("q") city: String, @Query("units") units: String): Single<ForecastResponse>
}