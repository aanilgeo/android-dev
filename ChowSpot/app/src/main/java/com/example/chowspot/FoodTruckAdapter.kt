package com.example.chowspot

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodTruckAdapter(private val foodTruckList: List<FoodTruck>) :
    RecyclerView.Adapter<FoodTruckAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val truckName: TextView = view.findViewById(R.id.truckName)
        val truckDetails: TextView = view.findViewById(R.id.truckDetails)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_food_truck, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val foodTruck = foodTruckList[position]
        holder.truckName.text = foodTruck.name
        holder.truckDetails.text = "Address: ${foodTruck.address}, Rating: ${foodTruck.rating ?: "N/A"}"

        // Handle item click to navigate to details
        holder.itemView.setOnClickListener {
            val context = it.context
            val intent = Intent(context, FoodTruckDetailsActivity::class.java).apply {
                putExtra("TRUCK_NAME", foodTruck.name)
                putExtra("TRUCK_ADDRESS", foodTruck.address)
                putExtra("TRUCK_RATING", foodTruck.rating?.toString() ?: "N/A")
                putExtra("TRUCK_LOCATION", "${foodTruck.geometry.location.lat},${foodTruck.geometry.location.lng}") // Pass location
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return foodTruckList.size
    }
}