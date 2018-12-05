package com.avukelic.weatherapp.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.avukelic.weatherapp.R

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        initUi()
    }

    abstract fun getLayout(): Int

    abstract fun initUi()

    abstract fun initToolbar()
}