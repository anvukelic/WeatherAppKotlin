package com.avukelic.weatherapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ForecastResponse(
        @Expose
        @SerializedName("list")
        var forecastWeather : List<WeatherResponse>
)