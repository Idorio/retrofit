package com.example.retrofit.retrofit.responce


import com.google.gson.annotations.SerializedName

data class WeatherResponse(

    val forecast: Forecast
)

    data class Forecast(
        @SerializedName("forecastday")
        val forecastday: List<Forecastday>
    ) {
        data class Forecastday(
            @SerializedName("date")
            val date: String,
            @SerializedName("date_epoch")
            val dateEpoch: Int,
            @SerializedName("day")
            val day: Day
        ) {
            data class Day(
                @SerializedName("maxtemp_c")
                val maxtempC: Double,

                @SerializedName("mintemp_c")
                val mintempC: Double,


            )
        }
    }
