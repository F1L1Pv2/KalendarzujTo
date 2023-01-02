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

    private var startDate: Calendar = Calendar.getInstance()
    private var endDate: Calendar = Calendar.getInstance()


    private var tripLength: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val calendarView = findViewById<CalendarView>(R.id.calendarView)

        calendarView.visibility = View.INVISIBLE

        val twoYearsFromNow = Calendar.getInstance().apply { add(Calendar.YEAR, 2) }
        calendarView.minDate = Calendar.getInstance().timeInMillis
        calendarView.maxDate = twoYearsFromNow.timeInMillis


        val startDateButton = findViewById<Button>(R.id.startDateButton)
        startDateButton.setOnClickListener {

            calendarView.visibility = View.VISIBLE
            calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->

                startDate.set(year, month, dayOfMonth)
                calendarView.visibility = View.GONE

                tripLength = calculateTripLength()
                val tripLengthTextView = findViewById<TextView>(R.id.tripLengthTextView)
                tripLengthTextView.text = "$tripLength dni"
            }
        }

        val endDateButton = findViewById<Button>(R.id.endDateButton)
        endDateButton.setOnClickListener {

            calendarView.visibility = View.VISIBLE
            calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->

                endDate.set(year, month, dayOfMonth)
                calendarView.visibility = View.GONE


                tripLength = calculateTripLength()
                val tripLengthTextView = findViewById<TextView>(R.id.tripLengthTextView)
                tripLengthTextView.text = "$tripLength dni"
            }
        }
    }
}

//todo zrobienie funkcji obliczajacej dlugosc podrozy