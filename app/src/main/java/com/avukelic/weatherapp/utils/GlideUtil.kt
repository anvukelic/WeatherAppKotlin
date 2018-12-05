package com.avukelic.weatherapp.utils

import android.content.Context
import android.widget.ImageView
import com.avukelic.weatherapp.Constants
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GlideUtil {
    companion object {
        fun glideImage(context : Context, container : ImageView, description : String){
            Glide.with(context)
                    .load(Constants.IMAGE_BASE_URL + getImagePath(description))
                    .apply(RequestOptions().override(300, 300))
                    .into(container)
        }
        private fun getImagePath(description : String) : String = when(description){
            Constants.SNOW_CASE -> Constants.SNOW
            Constants.CLEAR_CASE -> Constants.SUN
            Constants.CLOUD_CASE -> Constants.CLOUD
            Constants.FOG_CASE -> Constants.FOG
            Constants.HAZE_CASE -> Constants.FOG
            Constants.MIST_CASE -> Constants.FOG
            else -> Constants.RAIN
        }
    }

}