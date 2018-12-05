package com.avukelic.weatherapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Weather(

        @Expose
        @SerializedName("main")
        var main : String,
        @Expose
        @SerializedName("description")
        var description : String

)