package com.example.android.diceroller

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.splash_screen_layout.*

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen_layout)

        the_vacuum.setImageResource(R.drawable.the_vacuum)

        val timeout = 2500
        val splash = Intent(this@SplashScreen, MainActivity::class.java)
        Handler().postDelayed({
            startActivity(splash)
            finish()
        }, timeout.toLong())
    }


}