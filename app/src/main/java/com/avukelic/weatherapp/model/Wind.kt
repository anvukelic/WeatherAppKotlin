package com.avukelic.weatherapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Wind(
        @Expose
        @SerializedName("speed")
        var speed : Double,
        @Expose
        @SerializedName("deg")
        var deg : Double

)