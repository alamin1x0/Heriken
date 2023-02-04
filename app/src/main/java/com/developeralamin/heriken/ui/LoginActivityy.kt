package com.developeralamin.heriken.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.developeralamin.heriken.MainActivity
import com.developeralamin.heriken.R
import com.developeralamin.heriken.databinding.ActivityLoginBinding


class LoginActivityy : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
       supportActionBar?.hide()

//        val actionBar: ActionBar?
//        actionBar = supportActionBar
//        val colorDrawable = ColorDrawable(Color.parseColor("#70c332"))
//        actionBar!!.setBackgroundDrawable(colorDrawable)

        window.setStatusBarColor(ContextCompat.getColor(applicationContext, R.color.new_item));

        binding.sendOtp.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }

    }
}