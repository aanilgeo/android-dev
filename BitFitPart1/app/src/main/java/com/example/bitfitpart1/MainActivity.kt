package com.example.bitfitpart1

import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bitfitpart1.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sleepEntryAdapter: SleepEntryAdapter
    private val sleepEntryDao by lazy { BitFitDatabase.getDatabase(this).sleepEntryDao() }
    private var hoursSlept = 6 // Default starting value
    private var feelingScore = 5 // Default starting value

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupSeekBars()
        loadSleepEntries()

        // Add Entry button click listener
        binding.addEntryButton.setOnClickListener {
            val notes = binding.notesField.text.toString()
            addSleepEntry(hoursSlept, feelingScore, notes)
            binding.notesField.text.clear()
        }
    }

    private fun setupRecyclerView() {
        sleepEntryAdapter = SleepEntryAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = sleepEntryAdapter
        }
    }

    private fun setupSeekBars() {
        // Hours Slept SeekBar listener
        binding.hoursSleptSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                hoursSlept = progress
                binding.hoursSleptValue.text = "$hoursSlept hours"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Feeling Score SeekBar listener
        binding.feelingSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                feelingScore = progress
                binding.feelingValue.text = "Feeling: $feelingScore"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    private fun addSleepEntry(hours: Int, feeling: Int, notes: String) {
        if (hours <= 0) {
            Toast.makeText(this, "Please enter valid hours of sleep", Toast.LENGTH_SHORT).show()
            return
        }

        val sleepEntry = SleepEntry(hoursSlept = hours, feelingScore = feeling, notes = notes)
        CoroutineScope(Dispatchers.IO).launch {
            sleepEntryDao.insert(sleepEntry)
            loadSleepEntries()
            calculateAverages()
        }
    }

    private fun loadSleepEntries() {
        CoroutineScope(Dispatchers.IO).launch {
            val entries = sleepEntryDao.getAllEntries()
            runOnUiThread {
                sleepEntryAdapter.updateEntries(entries)
            }
        }
    }

    private fun calculateAverages() {
        CoroutineScope(Dispatchers.IO).launch {
            val entries = sleepEntryDao.getAllEntries()
            val averageHours = entries.map { it.hoursSlept }.average()
            val averageFeeling = entries.map { it.feelingScore }.average()

            runOnUiThread {
                binding.averageHoursSlept.text = "Average hours slept: ${"%.1f".format(averageHours)}"
                binding.averageFeeling.text = "Average feeling: ${"%.1f".format(averageFeeling)}"
            }
        }
    }
}