package com.example.ticketflixapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ticketflixapp.databinding.ActivityOrderDetailsBinding

class OrderDetailsActivity : AppCompatActivity() {
    private val TAG = "DetailsOrderActivityRun"
    private lateinit var binding: ActivityOrderDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnOrder.setOnClickListener {
                val intentToOrderSummaryActivity = Intent(this@OrderDetailsActivity, OrderSummaryActivity::class.java)
                startActivity(intentToOrderSummaryActivity)
            }
        }


    }
}