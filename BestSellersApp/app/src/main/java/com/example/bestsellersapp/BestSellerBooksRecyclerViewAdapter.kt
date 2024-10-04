package com.example.bestsellersapp

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class BestSellerBooksRecyclerViewAdapter(
    private val books: List<BestSellerBook>,
    private val listener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<BestSellerBooksRecyclerViewAdapter.BookViewHolder>() {

    inner class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rankingView: TextView = view.findViewById(R.id.book_ranking)
        val titleView: TextView = view.findViewById(R.id.book_title)
        val authorView: TextView = view.findViewById(R.id.book_author)
        val imageView: ImageView = view.findViewById(R.id.book_image)
        val descriptionView: TextView = view.findViewById(R.id.book_description)
        val buyButton: Button = view.findViewById(R.id.buy_button)

        fun bind(book: BestSellerBook) {
            rankingView.text = book.rank.toString()
            titleView.text = book.title
            authorView.text = book.author
            descriptionView.text = book.description
            Glide.with(itemView.context)
                .load(book.bookImageUrl)
                .centerInside()
                .into(imageView)

            buyButton.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(book.amazonUrl))
                itemView.context.startActivity(intent)
            }

            itemView.setOnClickListener {
                listener?.onItemClick(book)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_best_seller_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount(): Int {
        return books.size
    }
}
