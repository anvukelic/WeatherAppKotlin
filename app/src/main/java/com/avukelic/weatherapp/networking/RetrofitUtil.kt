package com.avukelic.weatherapp.networking

import com.avukelic.weatherapp.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitUtil {

    companion object {
        fun createRetrofit(): Retrofit {
            return Retrofit.Builder()
                    .baseUrl(Constants.WEATHER_BASE_URL)
                    .client(okHttpClient())
                    .addConverterFactory(GsonConverterFactory.create(getGson()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }

        fun getGson(): Gson {
            return getCommonBuilder()
                    .create();
        }

        fun getCommonBuilder(): GsonBuilder{
            return GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        }

        private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
            return HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        fun okHttpClient() : OkHttpClient{
            return OkHttpClient.Builder()
                    .addInterceptor(provideLoggingInterceptor())
                    .build()
        }
    }


}