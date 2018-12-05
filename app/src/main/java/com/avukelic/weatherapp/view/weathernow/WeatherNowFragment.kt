package com.avukelic.weatherapp.view.weathernow


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.view.View

import com.avukelic.weatherapp.R
import com.avukelic.weatherapp.base.BaseFragment
import com.avukelic.weatherapp.model.WeatherResponse
import com.avukelic.weatherapp.utils.GlideUtil
import com.avukelic.weatherapp.utils.getTimeNow
import com.avukelic.weatherapp.utils.roundToString
import com.avukelic.weatherapp.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.layout_weather_now.*

class WeatherNowFragment : BaseFragment() {

    interface OnWeatherResponseSuccessListener{
        fun onWeatherResponseSuccessful(cityName : String)
        fun showProgressBar()
        fun hideProgressBar()
    }

    lateinit var listener : OnWeatherResponseSuccessListener
    private lateinit var weatherViewModel: WeatherViewModel

    override fun getLayout(): Int {
        return R.layout.fragment_weather_now
    }

    override fun initUi() {
        initViewModel()
        fetchData()
    }

    override fun initViewModel() {
        weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)
        observeData()
    }

    override fun fetchData() {
        weatherViewModel.getNowWeather("Osijek")
    }

    private fun observeData() {
        weatherViewModel.weatherNowLiveData.observe(this, Observer { showWeatherNowData(it) })
        weatherViewModel.loading.observe(this, Observer { manageLoading(it) })
    }

    private fun manageLoading(it: Boolean?) {
        if (it!!) {
            listener.showProgressBar()
        } else {
            listener.hideProgressBar()
        }
    }

    private fun showWeatherNowData(it: WeatherResponse?) = it?.let {
        weatherNowTemperature.text = resources.getString(R.string.weather_temperature, it.main.temperature.roundToString())
        weatherNowDate.text = it.time.getTimeNow()
        weatherNowDescription.text = it.weather[0].description
        weatherNowWind.text = resources.getString(R.string.weather_wind_speed, it.wind.speed.toFloat())
        weatherNowPressure.text = resources.getString(R.string.weather_pressure, it.main.pressure.toFloat())
        weatherNowHumidity.text = resources.getString(R.string.weather_humidity, it.main.humidity)
        context?.let { it1 -> GlideUtil.glideImage(it1, weatherNowImageIcon, it.weather[0].main) }
        listener.onWeatherResponseSuccessful(it.cityName)
    }




}
