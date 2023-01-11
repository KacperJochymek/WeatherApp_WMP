package com.example.aplikacja_wmp.Calendar

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aplikacja_wmp.CompassActivity
import com.example.aplikacja_wmp.FlashlightActivity
import com.example.aplikacja_wmp.MainActivity2
import com.example.aplikacja_wmp.R
import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar

class CalendarActivity : AppCompatActivity() {

    //private val time: Date = TODO()
    private lateinit var tvDatePicker : TextView
    private lateinit var btnDatePicker : Button

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_calendar)

        tvDatePicker = findViewById(R.id.tvDate)
        btnDatePicker = findViewById(R.id.btnDatePicker)

        val myCalendar = java.util.Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
            myCalendar.set(java.util.Calendar.YEAR, year)
            myCalendar.set(java.util.Calendar.MONTH, month)
            myCalendar.set(java.util.Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(myCalendar)
        }
        btnDatePicker.setOnClickListener{
            DatePickerDialog(this, datePicker, myCalendar.get(java.util.Calendar.YEAR), myCalendar.get(java.util.Calendar.MONTH),
            myCalendar.get(java.util.Calendar.DAY_OF_MONTH)).show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_nav,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.home->{
                 startActivity(Intent(this, MainActivity2::class.java))
                return true
            }
            R.id.calendar->{
                //startActivity(Intent(this, CalendarActivity::class.java))
                return true
            }
            R.id.compass->{
                startActivity(Intent(this, CompassActivity::class.java))
                return true
            }
            R.id.flashlight->{
                startActivity(Intent(this, FlashlightActivity::class.java))
                return true
            }
            else->false
        }
    }

    private fun updateLable(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.ENGLISH)
        tvDatePicker.setText(sdf.format(myCalendar.time))

    }

}