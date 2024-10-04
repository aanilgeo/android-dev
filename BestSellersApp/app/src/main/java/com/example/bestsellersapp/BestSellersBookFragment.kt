package com.example.bestsellersapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.ContentLoadingProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.google.gson.Gson
import okhttp3.Headers

class BestSellerBooksFragment : Fragment(), OnListFragmentInteractionListener {

    private lateinit var progressBar: ContentLoadingProgressBar
    private lateinit var recyclerView: RecyclerView
    private lateinit var books: List<BestSellerBook>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_best_sellers_books_list, container, false)
        progressBar = view.findViewById(R.id.progress) as ContentLoadingProgressBar
        recyclerView = view.findViewById(R.id.list) as RecyclerView
        recyclerView.layoutManager = GridLayoutManager(context, 2)

        fetchBestSellers()

        return view
    }

    private fun fetchBestSellers() {
        progressBar.show()

        val client = AsyncHttpClient()
        val params = RequestParams()
        params["api-key"] = BuildConfig.NY_TIMES_API_KEY

        client.get("https://api.nytimes.com/svc/books/v3/lists/current/hardcover-fiction.json", params, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                progressBar.hide()

                val results = json.jsonObject.getJSONObject("results")

                val booksJson = results.getJSONArray("books")

                val gson = Gson()
                books = gson.fromJson(booksJson.toString(), Array<BestSellerBook>::class.java).toList()

                recyclerView.adapter = BestSellerBooksRecyclerViewAdapter(books, this@BestSellerBooksFragment)
            }

            override fun onFailure(statusCode: Int, headers: Headers?, response: String?, throwable: Throwable?) {
                progressBar.hide()
            }
        })
    }

    override fun onItemClick(item: BestSellerBook) {
    }
}


