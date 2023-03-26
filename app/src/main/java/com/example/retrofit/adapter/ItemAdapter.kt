package com.example.retrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.databinding.DayWeatherItemBinding
import com.example.retrofit.retrofit.responce.Forecast

class ItemAdapter : RecyclerView.Adapter<ItemViewHolder>() {

    private val listItem = mutableListOf<Forecast.Forecastday>()

    fun submitList(list: List<Forecast.Forecastday>){
        this.listItem.clear()
        this.listItem.addAll(list)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val viewBinding = DayWeatherItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ItemViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(listItem[position])
    }

    override fun getItemCount(): Int {
        return listItem.size
    }
}


