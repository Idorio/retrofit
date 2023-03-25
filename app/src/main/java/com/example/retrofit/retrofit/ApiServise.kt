package com.example.retrofit.retrofit

import com.example.retrofit.retrofit.responce.Forecast
import com.example.retrofit.retrofit.responce.WeatherResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServise {

        @GET("forecast.json")


     suspend   fun getWeather(
            @Query("q")
            q :String,
            @Query("key")
            key: String,

        ): WeatherResponse



    }


