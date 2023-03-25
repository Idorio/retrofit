package com.example.retrofit.adapter

import android.view.LayoutInflater

import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView


import com.example.retrofit.databinding.ListBinding
import com.example.retrofit.retrofit.responce.Forecast


class ItemAdapter() : RecyclerView.Adapter<ItemViewHolder>() {

    private var listItem = mutableListOf<Forecast.Forecastday.Day>()

    fun submitList(list: List<Forecast.Forecastday.Day>){
        this.listItem.clear()
        this.listItem = list.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val viewBinding = ListBinding.inflate(
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


