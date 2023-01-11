package com.example.aplikacja_wmp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.aplikacja_wmp.Calendar.CalendarActivity
import com.example.aplikacja_wmp.Compass.Compass
import com.example.aplikacja_wmp.Compass.CompassView

class CompassActivity : AppCompatActivity() {

    private var compass: Compass? = null
    private var compassView: CompassView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_compass)

        compassView = findViewById(R.id.compassView)

        setupCompass()
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
                startActivity(Intent(this, CalendarActivity::class.java))
                return true
            }
            R.id.compass->{
                //startActivity(Intent(this,CompassActivity::class.java))
                return true
            }
            R.id.flashlight->{
                startActivity(Intent(this,FlashlightActivity::class.java))
                return true
            }
            else->false
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart(): Start compass.")
        compass?.start()
    }

    override fun onPause() {
        super.onPause()
        compass?.stop()
    }

    private fun setupCompass() {
        compass = Compass(this)
        val cl = getCompassListener()
        compass?.setListener(cl)
    }

    override fun onResume() {
        super.onResume()
        compass?.start()
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop(): Stop compass.")
        compass?.stop()
    }

    private fun getCompassListener(): Compass.CompassListener? {
        return object : Compass.CompassListener {
            override fun onNewAlpha(alpha: Float) {
                Thread(Runnable {
                    compassView?.adjustArrow(alpha)
                }).start()
            }
        }
    }

    companion object {
        const val TAG = "MainActivity"
    }
}