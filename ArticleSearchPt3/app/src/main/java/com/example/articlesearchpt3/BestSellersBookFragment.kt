package com.example.articlesearchpt3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.ContentLoadingProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.google.gson.Gson
import okhttp3.Headers

class BestSellersFragment : Fragment() {

    private lateinit var progressBar: ContentLoadingProgressBar
    private lateinit var recyclerView: RecyclerView
    private lateinit var emptyStateTextView: TextView
    private lateinit var books: List<BestSellerBook>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_best_sellers_books_list, container, false)

        progressBar = view.findViewById(R.id.progress)
        recyclerView = view.findViewById(R.id.list)
        emptyStateTextView = view.findViewById(R.id.emptyStateText) // Initialize the empty state TextView

        recyclerView.layoutManager = GridLayoutManager(context, 2)

        fetchBestSellers() // Fetch data from API

        return view
    }

    private fun fetchBestSellers() {
        progressBar.show() // Show progress bar during API call
        emptyStateTextView.visibility = View.GONE // Hide empty state message initially

        val client = AsyncHttpClient()
        val params = RequestParams()
        params["api-key"] = BuildConfig.NY_TIMES_API_KEY

        client.get("https://api.nytimes.com/svc/books/v3/lists/current/hardcover-fiction.json", params, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                progressBar.hide()
                Log.d("BestSellersFragment", "API Response: ${json.jsonObject}")

                val results = json.jsonObject.getJSONObject("results")
                val booksJson = results.getJSONArray("books")
                books = Gson().fromJson(booksJson.toString(), Array<BestSellerBook>::class.java).toList()

                if (books.isNotEmpty()) {
                    emptyStateTextView.visibility = View.GONE
                    recyclerView.adapter = BestSellerBooksRecyclerViewAdapter(books)
                } else {
                    emptyStateTextView.visibility = View.VISIBLE
                }
            }

            override fun onFailure(statusCode: Int, headers: Headers?, response: String?, throwable: Throwable?) {
                progressBar.hide()
                emptyStateTextView.visibility = View.VISIBLE
                Log.e("BestSellersFragment", "Error fetching best sellers: ${throwable?.message}")
                Toast.makeText(context, "Failed to load data. Please try again.", Toast.LENGTH_SHORT).show()
            }
        })
    }
}