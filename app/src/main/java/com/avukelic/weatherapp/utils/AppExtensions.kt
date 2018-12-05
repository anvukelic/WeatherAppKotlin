package com.avukelic.weatherapp.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import java.text.SimpleDateFormat
import java.util.*


fun Double.roundToString() : String = this.toInt().toString()

fun Long.getTimeNow() : String = SimpleDateFormat("EEE, MMMM dd").format(Date(this*1000))

fun FragmentManager.replaceFragment(frame: Int, fragment : Fragment) = this.beginTransaction().replace(frame, fragment).commit()