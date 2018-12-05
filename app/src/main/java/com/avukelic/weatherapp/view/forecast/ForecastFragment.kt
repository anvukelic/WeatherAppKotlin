package com.avukelic.weatherapp.view.forecast


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.opengl.Visibility
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.avukelic.weatherapp.R
import com.avukelic.weatherapp.base.BaseFragment
import com.avukelic.weatherapp.model.ForecastResponse
import com.avukelic.weatherapp.viewmodel.ForecastViewModel
import kotlinx.android.synthetic.main.fragment_forecast.*


class ForecastFragment : BaseFragment() {


    private lateinit var forecastViewModel: ForecastViewModel
    var adapter = ForecastAdapter()

    override fun getLayout(): Int {
        return R.layout.fragment_forecast
    }

    override fun initUi() {
        initRecyclerView()
        initViewModel()
        fetchData()
    }

    private fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        forecastRecyclerView.layoutManager = linearLayoutManager
        forecastRecyclerView.itemAnimator = DefaultItemAnimator()
        forecastRecyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        forecastRecyclerView.adapter = adapter
    }


    override fun initViewModel() {
        forecastViewModel = ViewModelProviders.of(this).get(ForecastViewModel::class.java)
        observeData()
    }

    private fun observeData() {
        forecastViewModel.forecastLiveData.observe(this, Observer { showWeatherNowData(it) })
    }

    private fun showWeatherNowData(it: ForecastResponse?) {
        it?.let { it ->
            forecastProgressBar.visibility = View.GONE
            forecastRecyclerView.visibility = View.VISIBLE
            adapter.setForecastWeather(it.forecastWeather) }
    }


    override fun fetchData() {
        forecastViewModel.getForecast("Osijek")
    }


}
