package com.example.ticketflixapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ticketflixapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val TAG = "LoginActivityTicketApp"
    private lateinit var binding: ActivityLoginBinding

    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_PASSWORD = "extra_password"
        const val DEFAULT_USERNAME = "annisaurohmah"
        const val DEFAULT_PASSWORD = "497807"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnLogin.setOnClickListener {
                val inputUsername = usernameField.text.toString()
                val inputPassword = passwordField.text.toString()

                // Check if input matches the default username and password
                if (inputUsername == DEFAULT_USERNAME && inputPassword == DEFAULT_PASSWORD) {
                    val intentToMainActivity = Intent(this@LoginActivity, MainActivity::class.java)
                        .apply {
                            putExtra("EXTRA_USERNAME", inputUsername)
                            putExtra("EXTRA_PASSWORD", inputPassword)
                        }
                    startActivity(intentToMainActivity)
                } else {
                    // Show an error message or perform appropriate action
                    Toast.makeText(this@LoginActivity, "Invalid username or password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
