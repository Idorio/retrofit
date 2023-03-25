package com.example.retrofit.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.databinding.ListBinding
import com.example.retrofit.retrofit.responce.Forecast

class ItemViewHolder(
    private val viewBinding: ListBinding

) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(weatherResponse: Forecast.Forecastday.Day) {

        viewBinding.info.text = weatherResponse.maxtempC.toInt().toString()

    }
}