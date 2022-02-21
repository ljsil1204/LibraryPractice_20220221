package com.neppplus.librarypractice_20220221

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val myHandler = Handler(Looper.getMainLooper())
        myHandler.postDelayed({

//            shift + Tab => 들여쓰기 바깥으로
          val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)

            finish()

        }, 2500)
    }
}