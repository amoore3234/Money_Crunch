package com.example.moneycrunch

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class CrunchSplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crunch_splash_screen)

        supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this@CrunchSplashScreen, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}