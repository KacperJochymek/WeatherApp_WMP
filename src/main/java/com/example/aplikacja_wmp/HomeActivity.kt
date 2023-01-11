package com.example.aplikacja_wmp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.aplikacja_wmp.Calendar.CalendarActivity
import com.example.aplikacja_wmp.Compass.Compass
import com.example.aplikacja_wmp.databinding.ActivityHome2Binding
import com.example.aplikacja_wmp.databinding.FragmentCalendarBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home2.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_nav,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.home->{
                startActivity(Intent(this,MainActivity2::class.java))
                return true
            }
            R.id.calendar->{
                startActivity(Intent(this,CalendarActivity::class.java))
                return true
            }
            R.id.compass->{
                startActivity(Intent(this,CompassActivity::class.java))
                return true
            }
            R.id.flashlight->{
                startActivity(Intent(this,FlashlightActivity::class.java))
                return true
            }
            else->false
        }
    }

}


