package com.example.flixsterpart2

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.flixsterpart2.databinding.ItemPersonBinding

class PersonAdapter(private val people: List<Person>) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemPersonBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(person: Person) {
            binding.tvName.text = person.name

            // Load the actor profile image with rounded corners using Glide
            Glide.with(binding.root.context)
                .load(person.getProfileImageUrl())
                .apply(RequestOptions().transform(RoundedCorners(80))) // Adding rounded corners to profile image
                .into(binding.ivProfile)

            // Click listener for person details with shared element transition
            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, PersonDetailActivity::class.java).apply {
                    putExtra("name", person.name)
                    putExtra("known_for", person.knownFor)
                    putExtra("profile_path", person.getProfileImageUrl())
                }

                // Create the shared element transition animation for the profile image
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    binding.root.context as android.app.Activity,
                    binding.ivProfile, // View to be transitioned
                    "profile_image_transition"
                )

                // Start the detail activity with the shared element transition
                binding.root.context.startActivity(intent, options.toBundle())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPersonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(people[position])
    }

    override fun getItemCount(): Int = people.size
}