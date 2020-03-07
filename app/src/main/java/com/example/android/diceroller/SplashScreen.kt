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

        val timeout = 2000
        val homeIntent = Intent(this@SplashScreen, MainActivity::class.java)
        Handler().postDelayed({
            //TODO:Do some stuff here
            startActivity(homeIntent)
            finish()
        }, timeout.toLong())
    }


}