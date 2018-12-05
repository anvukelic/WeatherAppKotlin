package com.avukelic.weatherapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherResponse(
        @Expose
        @SerializedName("weather")
        var weather: List<Weather>,

        @Expose
        @SerializedName("main")
        var main: Main,

        @Expose
        @SerializedName("dt")
        var time: Long,

        @Expose
        @SerializedName("wind")
        var wind: Wind,

        @Expose
        @SerializedName("name")
        var cityName: String

)