package com.example.wishlist

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Item(val name: String, val price: String, val url: String)

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<Item>()
    private lateinit var adapter: ItemAdapter
    private lateinit var totalPriceBar: TextView
    private var totalPrice = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextPrice = findViewById<EditText>(R.id.editTextPrice)
        val editTextUrl = findViewById<EditText>(R.id.editTextUrl)
        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        totalPriceBar = findViewById(R.id.totalPriceBar)

        adapter = ItemAdapter(items, ::updateTotalPrice)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        buttonAdd.setOnClickListener {
            val name = editTextName.text.toString()
            val priceText = editTextPrice.text.toString()
            val url = editTextUrl.text.toString()

            if (name.isNotEmpty() && priceText.isNotEmpty() && url.isNotEmpty()) {
                val price = priceText.toDoubleOrNull()
                if (price != null) {
                    val item = Item(name, priceText, url)
                    items.add(item)
                    adapter.notifyItemInserted(items.size - 1)
                    updateTotalPrice() // Update total price when item is added
                    editTextName.text.clear()
                    editTextPrice.text.clear()
                    editTextUrl.text.clear()
                } else {
                    Toast.makeText(this, "Invalid price format", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateTotalPrice() {
        totalPrice = items.sumOf { it.price.toDoubleOrNull() ?: 0.0 }
        totalPriceBar.text = "Total: $%.2f".format(totalPrice)
    }
}

class ItemAdapter(private val items: MutableList<Item>, private val updateTotalPrice: () -> Unit) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewPrice: TextView = itemView.findViewById(R.id.textViewPrice)
        val textViewUrl: TextView = itemView.findViewById(R.id.textViewUrl)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.textViewName.text = item.name
        holder.textViewPrice.text = "$${item.price}"
        holder.textViewUrl.text = item.url

        holder.itemView.setOnClickListener {
            try {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(item.url))
                ContextCompat.startActivity(it.context, browserIntent, null)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(it.context, "Invalid URL for ${item.name}", Toast.LENGTH_LONG).show()
            }
        }

        holder.itemView.setOnLongClickListener {
            items.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, items.size)
            updateTotalPrice()
            true
        }
    }

    override fun getItemCount(): Int = items.size
}


