package com.avukelic.weatherapp.interaction

import com.avukelic.weatherapp.model.ForecastResponse
import com.avukelic.weatherapp.model.WeatherResponse
import io.reactivex.Single

interface AliInteract {

    fun getWeather(location : String) : Single<WeatherResponse>

    fun getForecast(location : String) : Single<ForecastResponse>
}