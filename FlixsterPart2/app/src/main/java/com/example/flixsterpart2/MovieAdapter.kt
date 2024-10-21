package com.example.flixsterpart2

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.flixsterpart2.databinding.ItemMovieBinding

class MovieAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.tvTitle.text = movie.title

            // Load the movie poster with rounded corners using Glide
            Glide.with(binding.root.context)
                .load(movie.getPosterImageUrl())
                .apply(RequestOptions().transform(RoundedCorners(80))) // Adding rounded corners to poster image
                .into(binding.ivPoster)

            // Click listener for movie details with shared element transition
            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, MovieDetailActivity::class.java).apply {
                    putExtra("title", movie.title)
                    putExtra("overview", movie.overview)
                    putExtra("poster_path", movie.getPosterImageUrl())
                }

                // Create the shared element transition animation for the poster image
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    binding.root.context as android.app.Activity,
                    binding.ivPoster, // View to be transitioned
                    "moviePoster"
                )

                // Start the detail activity with the shared element transition
                binding.root.context.startActivity(intent, options.toBundle())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size
}