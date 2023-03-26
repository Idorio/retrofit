package com.example.retrofit.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.databinding.DayWeatherItemBinding
import com.example.retrofit.retrofit.responce.Forecast

class ItemViewHolder(
    private val viewBinding: DayWeatherItemBinding
) : RecyclerView.ViewHolder(viewBinding.root) {
    fun bind(model: Forecast.Forecastday) {

        viewBinding.date.text = "Date is: ${model.date}"
        viewBinding.info.text = "Max tempreture is : ${model.day.maxtempC}"

    }
}