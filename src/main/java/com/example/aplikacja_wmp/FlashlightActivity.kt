package com.example.aplikacja_wmp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.hardware.camera2.CameraManager
import android.media.Image
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.aplikacja_wmp.Calendar.CalendarActivity
import com.example.aplikacja_wmp.databinding.ActivityHome2Binding

class FlashlightActivity : AppCompatActivity() {

        private lateinit var cameraM :CameraManager
        private lateinit var powerBtn :ImageButton
        var isFlash = false
        @SuppressLint("MissingInflatedId")
        @RequiresApi(Build.VERSION_CODES.M)
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.fragment_flashlight)

            powerBtn = findViewById(R.id.power)
            cameraM = getSystemService(Context.CAMERA_SERVICE) as CameraManager
            powerBtn.setOnClickListener{flashLightOnOrOff(it)}

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
                startActivity(Intent(this,CompassActivity::class.java))
                return true
            }
            R.id.flashlight->{
                //startActivity(Intent(this,FlashlightActivity::class.java))
                return true
            }
            else->false
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun flashLightOnOrOff(v: View?) {

        if(!isFlash){
            val cameraListId = cameraM.cameraIdList[0]
            cameraM.setTorchMode(cameraListId,true)
            isFlash = true
            powerBtn.setImageResource(R.drawable.ic_power_on)
            textMassge("Latarka włączona",this)
        }
        else{
            val cameraListId = cameraM.cameraIdList[0]
            cameraM.setTorchMode(cameraListId,false)
            isFlash = false
            powerBtn.setImageResource(R.drawable.ic_power_off)
            textMassge("Latarka wyłączona",this)
        }

    }

    private fun textMassge(s: String, c:Context) {

        Toast.makeText(c,s, Toast.LENGTH_SHORT).show()
    }

}