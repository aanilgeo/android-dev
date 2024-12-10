package com.example.chowspot

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodTruckAdapter
    private lateinit var searchView: SearchView
    private val foodTruckList = mutableListOf<FoodTruck>()
    private val filteredList = mutableListOf<FoodTruck>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        searchView = view.findViewById(R.id.searchView)
        recyclerView = view.findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = FoodTruckAdapter(filteredList)
        recyclerView.adapter = adapter

        fetchFoodTruckData("food") // Initial fetch with default keyword "food"
        setupSearchFunctionality()

        return view
    }

    private fun fetchFoodTruckData(query: String) {
        val apiService = RetrofitClient.instance.create(ApiService::class.java)
        val call = apiService.getNearbyPlaces(
            location = "40.7423,-74.1791", // NJIT campus coordinates
            radius = "1000", // 1 km radius
            type = "food", // Broader type
            keyword = query, // Pass the user's query
            apiKey = BuildConfig.PLACES_API_KEY
        )

        Log.d("HomeFragment", "API Call initiated with keyword: $query")

        call.enqueue(object : Callback<FoodTruckResponse> {
            override fun onResponse(
                call: Call<FoodTruckResponse>,
                response: Response<FoodTruckResponse>
            ) {
                if (response.isSuccessful) {
                    val foodTrucks = response.body()?.results ?: emptyList()
                    Log.d("HomeFragment", "Fetched ${foodTrucks.size} food trucks.")
                    foodTruckList.clear()
                    foodTruckList.addAll(foodTrucks)
                    filteredList.clear()
                    filteredList.addAll(foodTruckList)
                    adapter.notifyDataSetChanged()
                } else {
                    Log.e("HomeFragment", "Error: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<FoodTruckResponse>, t: Throwable) {
                Log.e("HomeFragment", "Failed to fetch data: ${t.message}")
            }
        })
    }

    private fun setupSearchFunctionality() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    fetchFoodTruckData(it) // Fetch data dynamically based on user input
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    if (it.isEmpty()) {
                        filteredList.clear()
                        filteredList.addAll(foodTruckList)
                        adapter.notifyDataSetChanged()
                    }
                }
                return true
            }
        })
    }
}