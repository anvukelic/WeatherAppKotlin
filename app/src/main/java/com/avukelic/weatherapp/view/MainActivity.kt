package com.avukelic.weatherapp.view

import android.view.View
import com.avukelic.weatherapp.R
import com.avukelic.weatherapp.base.BaseActivity
import com.avukelic.weatherapp.utils.replaceFragment
import com.avukelic.weatherapp.view.forecast.ForecastFragment
import com.avukelic.weatherapp.view.weathernow.WeatherNowFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), WeatherNowFragment.OnWeatherResponseSuccessListener {



    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun initUi() {
        initToolbar()
        initFragments()
    }

    private fun initFragments() {
        val weatherNowFragment = WeatherNowFragment()
        weatherNowFragment.listener = this
        supportFragmentManager.replaceFragment(R.id.mainWeatherNowFrame, weatherNowFragment)
    }

    override fun initToolbar() {
        setSupportActionBar(mainToolbar)
    }

    override fun onWeatherResponseSuccessful(cityName: String) {
        supportActionBar?.title = cityName
        val forecastFragment = ForecastFragment()
        supportFragmentManager.replaceFragment(R.id.mainForecastFrame, forecastFragment)
    }

    override fun showProgressBar() {
        mainProgressBar.visibility = View.VISIBLE
        mainAppBarLayout.visibility = View.GONE
    }

    override fun hideProgressBar() {
        mainProgressBar.visibility = View.GONE
        mainAppBarLayout.visibility = View.VISIBLE
    }
}
