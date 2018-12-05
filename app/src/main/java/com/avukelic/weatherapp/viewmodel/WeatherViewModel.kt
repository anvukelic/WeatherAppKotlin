package com.avukelic.weatherapp.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.avukelic.weatherapp.base.BaseViewModel
import com.avukelic.weatherapp.interaction.AliInteractImpl
import com.avukelic.weatherapp.model.WeatherResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherViewModel : BaseViewModel() {

    private val apiInteractor = AliInteractImpl()
    val weatherNowLiveData = MutableLiveData<WeatherResponse>()


    fun getNowWeather(location : String){
        loading.value = true
        addSubscription(apiInteractor.getWeather(location)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {handleWeatherNowResponse(it)},
                        {handleThrowable(it)}
                )
        )
    }

    private fun handleWeatherNowResponse(it: WeatherResponse?) {
        weatherNowLiveData.value = it
        loading.value = false
    }

    private fun handleThrowable(it: Throwable?) {
        loading.value = false
    }
}