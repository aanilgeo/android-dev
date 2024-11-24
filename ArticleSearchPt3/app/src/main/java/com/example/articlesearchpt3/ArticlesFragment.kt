package com.example.articlesearchpt3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.example.articlesearchpt3.databinding.FragmentArticlesBinding
import com.google.gson.Gson
import okhttp3.Headers
import org.json.JSONArray

class ArticlesFragment : Fragment() {

    private var _binding: FragmentArticlesBinding? = null
    private val binding get() = _binding!!
    private val articles: MutableList<Article> = mutableListOf()
    private lateinit var articleAdapter: ArticleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArticlesBinding.inflate(inflater, container, false)

        // Initialize RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        articleAdapter = ArticleAdapter(articles)
        binding.recyclerView.adapter = articleAdapter

        // Show progress bar and fetch articles
        binding.progressBar.visibility = View.VISIBLE
        binding.emptyStateText.visibility = View.GONE
        fetchArticles()

        return binding.root
    }

    private fun fetchArticles() {
        val client = AsyncHttpClient()
        val url = "https://api.nytimes.com/svc/search/v2/articlesearch.json?api-key=${BuildConfig.NY_TIMES_API_KEY}&q=technology"

        client.get(url, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                Log.d("ArticlesFragment", "API Response: ${json.jsonObject}")

                // Parse JSON response
                val docs: JSONArray = json.jsonObject.getJSONObject("response").getJSONArray("docs")
                val newArticles = Gson().fromJson(docs.toString(), Array<Article>::class.java).toList()

                // Hide progress bar and update UI
                binding.progressBar.visibility = View.GONE
                if (newArticles.isNotEmpty()) {
                    binding.emptyStateText.visibility = View.GONE
                    articles.clear()
                    articles.addAll(newArticles)
                    articleAdapter.notifyDataSetChanged()
                } else {
                    binding.emptyStateText.visibility = View.VISIBLE
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String?,
                throwable: Throwable?
            ) {
                Log.e("ArticlesFragment", "Error fetching articles: ${throwable?.message}")

                // Hide progress bar and show error message
                binding.progressBar.visibility = View.GONE
                binding.emptyStateText.visibility = View.VISIBLE
                Toast.makeText(requireContext(), "Failed to load articles. Please try again.", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}