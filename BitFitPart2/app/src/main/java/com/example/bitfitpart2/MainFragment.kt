package com.example.bitfitpart2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bitfitpart2.databinding.FragmentMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var sleepEntryAdapter: SleepEntryAdapter
    private val sleepEntryDao by lazy { BitFitDatabase.getDatabase(requireContext()).sleepEntryDao() }
    private var hoursSlept = 6 // Default starting value
    private var feelingScore = 5 // Default starting value

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        setupRecyclerView()
        setupSeekBars()
        loadSleepEntries()
        return binding.root
    }

    private fun setupRecyclerView() {
        sleepEntryAdapter = SleepEntryAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = sleepEntryAdapter
        }
    }

    private fun setupSeekBars() {
        // Hours Slept SeekBar listener
        binding.hoursSleptSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                hoursSlept = progress
                binding.hoursSleptValue.text = "$hoursSlept hours"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Feeling Score SeekBar listener
        binding.feelingSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                feelingScore = progress
                binding.feelingValue.text = "Feeling: $feelingScore"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Add Entry button click listener
        binding.addEntryButton.setOnClickListener {
            val notes = binding.notesField.text.toString()
            addSleepEntry(hoursSlept, feelingScore, notes)
            binding.notesField.text.clear()
        }
    }

    private fun addSleepEntry(hours: Int, feeling: Int, notes: String) {
        if (hours <= 0) {
            Toast.makeText(requireContext(), "Please enter valid hours of sleep", Toast.LENGTH_SHORT)
                .show()
            return
        }

        val sleepEntry = SleepEntry(hoursSlept = hours, feelingScore = feeling, notes = notes)
        CoroutineScope(Dispatchers.IO).launch {
            sleepEntryDao.insert(sleepEntry)
            loadSleepEntries()
        }
    }

    private fun loadSleepEntries() {
        CoroutineScope(Dispatchers.IO).launch {
            val entries = sleepEntryDao.getAllEntries()
            requireActivity().runOnUiThread {
                sleepEntryAdapter.updateEntries(entries)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

