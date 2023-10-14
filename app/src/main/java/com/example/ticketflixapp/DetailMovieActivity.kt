package com.example.ticketflixapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ticketflixapp.databinding.ActivityDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnGet.setOnClickListener {
                val intentToOrderDetailsActivity = Intent (this@DetailMovieActivity, OrderDetailsActivity::class.java)
                startActivity(intentToOrderDetailsActivity)
            }
        }
    }
}