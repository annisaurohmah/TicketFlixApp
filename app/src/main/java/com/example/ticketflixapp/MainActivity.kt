package com.example.ticketflixapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ticketflixapp.databinding.ActivityLoginBinding
import com.example.ticketflixapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivityHome"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            cardElemental.setOnClickListener{
                val intentToDetailMovieActivity = Intent(this@MainActivity, DetailMovieActivity::class.java)
                startActivity(intentToDetailMovieActivity)
            }
        }
    }
}