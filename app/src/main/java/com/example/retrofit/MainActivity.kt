package com.example.retrofit

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.adapter.ItemAdapter
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.retrofit.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    private val adapter: ItemAdapter by lazy { ItemAdapter() }
    private var binding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding?.root)


        binding?.rc?.layoutManager = LinearLayoutManager(this)
        binding?.rc?.adapter = adapter

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()


        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/v1/").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()
        val apiServise = retrofit.create(ApiService::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val response = apiServise
                .getWeather(
                    q = "London",
                    key = "7ffea88483fb4e648a360906232403",
                    days = "3"
                )
            runOnUiThread {
                adapter.submitList(response.forecast.forecastday)
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}













