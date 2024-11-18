package com.example.bitfitpart2

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bitfitpart2.databinding.FragmentDashboardBinding
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private val sleepEntryDao by lazy {
        BitFitDatabase.getDatabase(requireContext()).sleepEntryDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Load and display averages
        loadAverages()

        // Setup and load chart data
        loadChartData()
    }

    private fun loadAverages() {
        CoroutineScope(Dispatchers.IO).launch {
            val entries = sleepEntryDao.getAllEntries()
            val averageHours = entries.map { it.hoursSlept }.average()
            val averageFeeling = entries.map { it.feelingScore }.average()

            requireActivity().runOnUiThread {
                binding.averageHoursSlept.text =
                    "Average hours slept: ${"%.1f".format(averageHours)}"
                binding.averageFeelingScore.text =
                    "Average feeling score: ${"%.1f".format(averageFeeling)}"
            }
        }
    }

    private fun loadChartData() {
        CoroutineScope(Dispatchers.IO).launch {
            val entries = sleepEntryDao.getAllEntries()

            // Map database entries to BarEntry for the chart
            val barEntries = entries.mapIndexed { index, entry ->
                BarEntry(index.toFloat() + 1, entry.hoursSlept.toFloat()) // Day index vs Hours slept
            }

            // Create and customize the BarDataSet
            val barDataSet = BarDataSet(barEntries, "Sleep Data").apply {
                color = Color.BLUE
                valueTextColor = Color.BLACK
                valueTextSize = 12f
            }

            // Create BarData
            val barData = BarData(barDataSet)

            requireActivity().runOnUiThread {
                binding.barChart.apply {
                    data = barData
                    setFitBars(true)

                    // Disable the description text
                    description.isEnabled = false

                    // Legend adjustments
                    legend.apply {
                        textColor = Color.BLACK
                        textSize = 12f
                        isWordWrapEnabled = true
                        horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
                    }

                    // XAxis adjustments
                    xAxis.apply {
                        position = XAxis.XAxisPosition.BOTTOM
                        textColor = Color.BLACK
                        textSize = 12f
                        setDrawGridLines(false)
                        granularity = 1f
                        labelCount = barEntries.size
                    }

                    // YAxis adjustments (Left)
                    axisLeft.apply {
                        textColor = Color.BLACK
                        textSize = 12f
                        setDrawGridLines(false)
                    }

                    // YAxis adjustments (Right)
                    axisRight.apply {
                        textColor = Color.BLACK
                        textSize = 12f
                        setDrawGridLines(false)
                    }

                    // Add extra offsets to ensure no overlap
                    setExtraOffsets(10f, 10f, 10f, 30f) // Bottom padding increased
                    invalidate() // Refresh the chart
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}