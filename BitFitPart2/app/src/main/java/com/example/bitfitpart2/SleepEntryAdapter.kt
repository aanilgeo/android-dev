package com.example.bitfitpart2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SleepEntryAdapter(private var sleepEntries: MutableList<SleepEntry> = mutableListOf()) :
    RecyclerView.Adapter<SleepEntryAdapter.SleepEntryViewHolder>() {

    class SleepEntryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dateTextView: TextView = view.findViewById(R.id.dateTextView)
        val hoursTextView: TextView = view.findViewById(R.id.hoursTextView)
        val feelingTextView: TextView = view.findViewById(R.id.feelingTextView)
        val notesTextView: TextView = view.findViewById(R.id.notesTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepEntryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sleep_entry, parent, false)
        return SleepEntryViewHolder(view)
    }

    override fun onBindViewHolder(holder: SleepEntryViewHolder, position: Int) {
        val entry = sleepEntries[position]
        holder.dateTextView.text = entry.date
        holder.hoursTextView.text = "Hours Slept: ${entry.hoursSlept}"
        holder.feelingTextView.text = "Feeling Score: ${entry.feelingScore}"
        holder.notesTextView.text = "Notes: ${entry.notes}"
    }

    override fun getItemCount() = sleepEntries.size

    fun updateEntries(newEntries: List<SleepEntry>) {
        sleepEntries.clear()
        sleepEntries.addAll(newEntries)
        notifyDataSetChanged()
    }
}