package com.avukelic.weatherapp.view.forecast

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.avukelic.weatherapp.R
import com.avukelic.weatherapp.model.WeatherResponse
import com.avukelic.weatherapp.utils.GlideUtil
import com.avukelic.weatherapp.utils.roundToString
import kotlinx.android.synthetic.main.forecast_weather_list_item.view.*
import java.text.SimpleDateFormat
import java.util.*

class ForecastAdapter : RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    val forecastWeathers = ArrayList<WeatherResponse>()

    fun setForecastWeather(forecastWeather: List<WeatherResponse>) {
        this.forecastWeathers.clear()
        this.forecastWeathers.addAll(forecastWeather)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.forecast_weather_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return forecastWeathers.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val forecastWeather = forecastWeathers[position]
        GlideUtil.glideImage(holder.itemView.context, holder.forecastImage, forecastWeather.weather[0].main)
        holder.forecastTime.text = SimpleDateFormat("EEE hh:mm").format(Date(forecastWeather.time * 1000))
        holder.forecastTemperature.text = forecastWeather.main.temperature.roundToString()
        holder.forecastDescription.text = forecastWeather.weather[0].description
        holder.forecastHumidity.text = holder.itemView.context.resources
                .getString(R.string.weather_humidity, forecastWeather.main.humidity)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val forecastTime = view.forecastTime!!
        val forecastImage = view.forecastImage!!
        val forecastTemperature = view.forecastTemperature!!
        val forecastDescription = view.forecastDescription!!
        val forecastHumidity = view.forecastHumidity!!
    }
}