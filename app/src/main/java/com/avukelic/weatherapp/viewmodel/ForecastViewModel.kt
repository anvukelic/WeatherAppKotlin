package com.avukelic.weatherapp.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.avukelic.weatherapp.base.BaseViewModel
import com.avukelic.weatherapp.interaction.AliInteractImpl
import com.avukelic.weatherapp.model.ForecastResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ForecastViewModel : BaseViewModel() {

    val apiInteractor = AliInteractImpl()
    val forecastLiveData = MutableLiveData<ForecastResponse>()

    fun getForecast(location : String){
        addSubscription(apiInteractor.getForecast(location)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {handleWeatherNowResponse(it)},
                        {handleThrowable(it)}
                )
        )
    }

    private fun handleThrowable(it: Throwable?) {
    }

    private fun handleWeatherNowResponse(it: ForecastResponse?) {
        forecastLiveData.value = it
    }
}