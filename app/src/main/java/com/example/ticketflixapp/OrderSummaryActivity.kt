package com.example.ticketflixapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import com.example.ticketflixapp.databinding.ActivityOrderSummaryBinding

class OrderSummaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrderSummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderSummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val selectedCity = intent.getStringExtra("SELECTED_CITY")
        val selectedCinema = intent.getStringExtra("SELECTED_CINEMA")
        val selectedStudio = intent.getStringExtra("SELECTED_STUDIO")
        val selectedSeatA = intent.getStringExtra("SELECTED_SEAT_A")
        val selectedSeatNumber = intent.getStringExtra("SELECTED_SEAT_NUMBER")
        val selectedPaymentMethod = intent.getStringExtra("SELECTED_PAYMENT_METHOD")
        val selectedBank = intent.getStringExtra("SELECTED_BANK")
        val selectedDate = intent.getStringExtra("SELECTED_DATE")
        val selectedTime = intent.getStringExtra("SELECTED_TIME")


        with(binding){
            cinema.text = selectedCinema + ", " +selectedCity
            date.text = selectedDate
            time.text = selectedTime
            typeStudio.text = selectedStudio
            typeSeat.text = selectedSeatA + selectedSeatNumber

            val spannableString = SpannableString("$selectedPaymentMethod" + " (" + "$selectedBank" + ")")
            typePayment.text= spannableString

            backToHome.setOnClickListener{
                val intentData = Intent(this@OrderSummaryActivity, MainActivity::class.java)
                startActivity(intentData)
            }
            btnBack.setOnClickListener{
                val intentBack = Intent(this@OrderSummaryActivity, OrderDetailsActivity::class.java)
                startActivity(intentBack)
            }


    }
}
}