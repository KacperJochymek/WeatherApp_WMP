package com.example.aplikacja_wmp.Compass

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.aplikacja_wmp.R
import kotlinx.android.synthetic.main.compass_view.view.*

class CompassView(
    context: Context,
    attrs: AttributeSet
) : ConstraintLayout(context, attrs) {


    private var currentAlpha = 0f

    init {
        Log.d(TAG, "Kotlin init block called.")
        inflate(context, R.layout.compass_view, this)
        Log.d(TAG, "inflation started.")
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        Log.d(TAG, "onFinishInflate() called.")
    }

    fun adjustArrow(alpha: Float) {
        val an: Animation = RotateAnimation(
            -currentAlpha,
            -alpha,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        currentAlpha = alpha

        an.duration = 500
        an.repeatCount = 0
        an.fillAfter = true

        compass.startAnimation(an)
    }

    companion object {
        const val TAG = "Compass_View"
    }
}