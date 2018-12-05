package com.avukelic.weatherapp.interaction

import com.avukelic.weatherapp.App
import com.avukelic.weatherapp.Constants
import com.avukelic.weatherapp.model.ForecastResponse
import com.avukelic.weatherapp.model.WeatherResponse
import io.reactivex.Single

class AliInteractImpl : AliInteract {
    override fun getForecast(location: String): Single<ForecastResponse> {
        return App.weatherApiService.getForecast(Constants.API_KEY, location, Constants.METRIC)
    }

    override fun getWeather(location: String): Single<WeatherResponse> {
        return App.weatherApiService.getWeather(Constants.API_KEY, location, Constants.METRIC)
    }
}