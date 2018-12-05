package com.avukelic.weatherapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Main(

        @Expose
        @SerializedName("temp")
        var temperature : Double,

        @Expose
        @SerializedName("humidity")
        var humidity : Double,

        @Expose
        @SerializedName("pressure")
        var pressure : Double

)