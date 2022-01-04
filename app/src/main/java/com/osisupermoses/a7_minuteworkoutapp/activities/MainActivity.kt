package com.osisupermoses.a7_minuteworkoutapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.osisupermoses.a7_minuteworkoutapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.flStart.setOnClickListener {
            startActivity(Intent(this@MainActivity, ExerciseActivity::class.java))
        }

        binding.flBMI.setOnClickListener {
            startActivity(Intent(this@MainActivity, BMIActivity::class.java))
        }

        binding.flHistory.setOnClickListener {
            startActivity(Intent(this@MainActivity, HistoryActivity::class.java))
        }
    }
}