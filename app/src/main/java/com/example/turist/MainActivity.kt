package com.example.turist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.turist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                binding = ActivityMainBinding.inflate(layoutInflater)
                setContentView(binding.root)

                val btnShowTours: Button = findViewById(R.id.btnShowTours)
                btnShowTours.setOnClickListener {
                        val intent = Intent(this, TourListActivity::class.java)
                        startActivity(intent)
                }

                val btnSecondFeature: Button = findViewById(R.id.btnSecondFeature)
                btnSecondFeature.setOnClickListener {
                        val intent = Intent(this, MapActivity::class.java)
                        startActivity(intent)
                }

                val btnAboutSkopje: Button = findViewById(R.id.btnAboutSkopje)
                btnAboutSkopje.setOnClickListener {
                        val intent = Intent(this, AboutSkopjeActivity::class.java)
                        startActivity(intent)
                }
        }
}