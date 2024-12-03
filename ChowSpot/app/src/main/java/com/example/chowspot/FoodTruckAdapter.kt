package com.example.chowspot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodTruckAdapter(private val foodTruckList: List<String>) :
    RecyclerView.Adapter<FoodTruckAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val truckName: TextView = view.findViewById(R.id.truckName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_food_truck, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.truckName.text = foodTruckList[position]
    }

    override fun getItemCount(): Int {
        return foodTruckList.size
    }
}