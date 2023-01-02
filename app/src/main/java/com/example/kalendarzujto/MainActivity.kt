package com.example.kalendarzujto

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    // Zmienne aby przechowywac daty
    private var startDate: Calendar = Calendar.getInstance()
    private var endDate: Calendar = Calendar.getInstance()

    // Zmienne aby przechowywac ilosc dni
    private var tripLength: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ustawienie minimum i maksimum daty
        val calendarView = findViewById<CalendarView>(R.id.calendarView)

        calendarView.visibility = View.INVISIBLE

        val twoYearsFromNow = Calendar.getInstance().apply { add(Calendar.YEAR, 2) }
        calendarView.minDate = Calendar.getInstance().timeInMillis
        calendarView.maxDate = twoYearsFromNow.timeInMillis
    }
}
