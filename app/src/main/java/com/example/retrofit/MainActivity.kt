package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.adapter.ItemAdapter

import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.retrofit.*
import com.example.retrofit.retrofit.model.Day
import com.example.retrofit.retrofit.responce.Forecast
import com.example.retrofit.retrofit.responce.WeatherResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    private lateinit var adapter: ItemAdapter
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


//        binding.rc.layoutManager = LinearLayoutManager(this)
//        adapter = ItemAdapter()
//        binding.rc.adapter = adapter

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()


        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/v1/").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()
        val apiServise = retrofit.create(ApiServise::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val list = apiServise.getWeather("London", "7ffea88483fb4e648a360906232403")
            runOnUiThread {
                binding.tv.text = list.forecast.forecastday.get(0).toString()


            }

        }
    }
}













