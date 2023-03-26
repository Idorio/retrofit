package com.example.retrofit.retrofit

import com.example.retrofit.retrofit.responce.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("forecast.json")
    suspend fun getWeather(
        @Query("q")
        q: String,
        @Query("key")
        key: String,
        @Query("days")
        days: String
    ): WeatherResponse
}


