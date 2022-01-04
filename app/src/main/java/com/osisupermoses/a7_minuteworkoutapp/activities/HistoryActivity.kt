package com.osisupermoses.a7_minuteworkoutapp.activities

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.osisupermoses.a7_minuteworkoutapp.adapters.HistoryAdapter
import com.osisupermoses.a7_minuteworkoutapp.roomdatabase.HistoryDao
import com.osisupermoses.a7_minuteworkoutapp.roomdatabase.WorkoutApp
import com.osisupermoses.a7_minuteworkoutapp.databinding.ActivityHistoryBinding
import com.osisupermoses.a7_minuteworkoutapp.roomdatabase.HistoryEntity
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarHistoryActivity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "History"

        binding.toolbarHistoryActivity.setNavigationOnClickListener {
            onBackPressed()
        }

        val dao = (application as WorkoutApp).db.historyDao()
        getAllCompletedDates(dao)

        binding.tvClearAll.setOnClickListener {
            clearAllDates(dao)
        }

    }

    private fun getAllCompletedDates(historyDao: HistoryDao) {
        lifecycleScope.launch {
            historyDao.fetchAllDates().collect { allCompletedDatesList ->
                if (allCompletedDatesList.isNotEmpty()) {
                    binding.tvHistory.visibility = View.VISIBLE
                    binding.rvHistory.visibility = View.VISIBLE
                    binding.tvClearAll.visibility = View.VISIBLE
                    binding.tvNoDataAvailable.visibility = View.INVISIBLE

                    binding.rvHistory.layoutManager =
                        LinearLayoutManager(this@HistoryActivity)

                    val dates = ArrayList<String>()
                    for (date in allCompletedDatesList) {
                        dates.add(date.date)
                    }

                    val historyAdapter = HistoryAdapter(dates)
                    binding.rvHistory.adapter = historyAdapter
                } else {
                    binding.tvHistory.visibility = View.GONE
                    binding.rvHistory.visibility = View.GONE
                    binding.tvClearAll.visibility = View.GONE
                    binding.tvNoDataAvailable.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun clearAllDates(historyDao: HistoryDao) {
        val builder = AlertDialog.Builder(this)
        builder.setIcon(android.R.drawable.ic_dialog_alert)
        builder.setTitle("Clear All Records?")
        builder.setPositiveButton("Yes") { dialogInterface, _ ->
            lifecycleScope.launch {
                historyDao.deleteAllDates()
                Toast.makeText(
                    applicationContext,
                    "History cleared successfully.", Toast.LENGTH_LONG
                ).show()
            }
            dialogInterface.dismiss()
        }
        builder.setNegativeButton("No") { dialogInterface, _ ->
            dialogInterface.dismiss()
        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }
}