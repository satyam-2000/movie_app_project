package com.internshala.showapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val logo=findViewById<ImageView>(R.id.logo)
        val slideAnimation=AnimationUtils.loadAnimation(this,R.anim.slide)
        logo.startAnimation(slideAnimation)
        supportActionBar?.hide()
        Handler().postDelayed({
            val intent=Intent(this@Splash,MainActivity::class.java)
            startActivity(intent)
            finish()
        },3500)


    }
}