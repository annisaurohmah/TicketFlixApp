package com.example.ticketflixapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.widget.ArrayAdapter
import com.example.ticketflixapp.databinding.ActivityOrderDetailsBinding

class OrderDetailsActivity : AppCompatActivity() {
    private val TAG = "DetailsOrderActivityRun"
    private lateinit var binding: ActivityOrderDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cities = resources.getStringArray(R.array.city_array)
        val cinemas = resources.getStringArray(R.array.cinema_yogyakarta_array)
        val studios = resources.getStringArray(R.array.studio_type_array)
        val seatsA = resources.getStringArray(R.array.items_A_to_L_array)
        val seats = resources.getIntArray(R.array.numbers_1_to_10_array)
        val pay_method = resources.getStringArray(R.array.payment_methods_array)
        val bank = resources.getStringArray(R.array.bank_types_array)
//
//
        with(binding) {
            val citiesAdapter = ArrayAdapter(
                this@OrderDetailsActivity, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, cities
            )
            citiesAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )
            spinnerCities.adapter = citiesAdapter
//
            val cinemasAdapter = ArrayAdapter(
                this@OrderDetailsActivity, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, cinemas
            )
            cinemasAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )
            spinnerCinema.adapter = cinemasAdapter

            val studiosAdapter = ArrayAdapter(
                this@OrderDetailsActivity, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, studios
            )
            studiosAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )
            spinnerStudio.adapter = studiosAdapter

            val seatAAdapter = ArrayAdapter(
                this@OrderDetailsActivity, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, seatsA
            )
            seatAAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )
            spinnerSeatA.adapter = seatAAdapter


//
            val seatNumberStrings: Array<String> = seats.map { it.toString() }.toTypedArray()

// Membuat adapter untuk Spinner
            val adapter = ArrayAdapter(this@OrderDetailsActivity, android.R.layout.simple_spinner_item, seatNumberStrings)

// Menentukan tampilan dropdown
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

// Mengatur adapter ke Spinner
            spinnerSeats.adapter = adapter
//
            val PayAdapter = ArrayAdapter(
                this@OrderDetailsActivity, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, pay_method
            )
            PayAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )
            spinnerBill.adapter = PayAdapter

            val BankAdapter = ArrayAdapter(
                this@OrderDetailsActivity, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, bank
            )
            BankAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )
            spinnerBank.adapter = BankAdapter


            binding.datePicker.init(
                binding.datePicker.year,
                binding.datePicker.month,
                binding.datePicker.dayOfMonth
            ) { _, year, month, day ->
                val selectedDate = "$day/${month + 1}/$year"
                binding.selectDate.text = "Selected date is $selectedDate"
            }

            var selectedTime = ""
            pickerTime.setOnTimeChangedListener { _, hourOfDay, minutes ->
                selectedTime = String.format("%02d:%02d", hourOfDay, minutes)
            }


            btnOrder.setOnClickListener {
                // Mendapatkan nilai yang dipilih dari spinner dan picker
                val selectedCity = spinnerCities.selectedItem.toString()
                val selectedCinema = spinnerCinema.selectedItem.toString()
                val selectedStudio = spinnerStudio.selectedItem.toString()
                val selectedSeatA = spinnerSeatA.selectedItem.toString()
                val selectedSeatNumber = spinnerSeats.selectedItem.toString()
                val selectedPaymentMethod = spinnerBill.selectedItem.toString()
                val selectedBank = spinnerBank.selectedItem.toString()
                val selectedDate = binding.selectDate.text.toString()
                val selectedTime = selectedTime // Diambil dari pickerTime

                // Membuat intent untuk OrderSummaryActivity dan menyertakan data yang akan dikirimkan
                val intentToOrderSummaryActivity = Intent(this@OrderDetailsActivity, OrderSummaryActivity::class.java).apply {
                    putExtra("SELECTED_CITY", selectedCity)
                    putExtra("SELECTED_CINEMA", selectedCinema)
                    putExtra("SELECTED_STUDIO", selectedStudio)
                    putExtra("SELECTED_SEAT_A", selectedSeatA)
                    putExtra("SELECTED_SEAT_NUMBER", selectedSeatNumber)
                    putExtra("SELECTED_PAYMENT_METHOD", selectedPaymentMethod)
                    putExtra("SELECTED_BANK", selectedBank)
                    putExtra("SELECTED_DATE", selectedDate)
                    putExtra("SELECTED_TIME", selectedTime)
                }

                // Memulai activity OrderSummaryActivity dengan membawa data yang telah disiapkan
                startActivity(intentToOrderSummaryActivity)
            }

            btnBack.setOnClickListener{
                val intentBack = Intent(this@OrderDetailsActivity, DetailMovieActivity::class.java)
                startActivity(intentBack)
            }

        }
//

    }
}