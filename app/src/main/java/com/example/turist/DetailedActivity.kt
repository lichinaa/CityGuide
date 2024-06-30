package com.example.turist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.turist.databinding.ActivityDetailedBinding
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class DetailedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = this.intent
        if (intent != null) {
            val name = intent.getStringExtra("name")
            val time = intent.getStringExtra("time")
            val include = intent.getIntExtra("include", R.string.SkopjeTour)
            val desc = intent.getIntExtra("desc", R.string.SkopjeDesc)
            val image = intent.getIntExtra("image", R.drawable.img2)
            val price = intent.getStringExtra("price")

            binding.detailName.text = name
            binding.detailTime.text = time
            binding.detailDesc.setText(desc)
            binding.detailInclude.setText(include)
            binding.detailImage.setImageResource(image)
            binding.detailPrice.text = price

            binding.btnReserve.setOnClickListener {
                AlertDialog.Builder(this@DetailedActivity)
                    .setTitle("Reservation")
                    .setMessage("Successfully reserved your place")
                    .setPositiveButton("OK") { dialog, which ->
                        dialog.dismiss()
                    }
                    .show()
            }
        }

    }
}