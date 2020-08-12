package com.example.fightwithroom.ui

import MainActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fightwithroom.MyApp
import com.example.fightwithroom.R
import kotlinx.android.synthetic.main.activity_input_login.*

class InputLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_login)
        setupListeners()
    }

    private fun setupListeners() {
        tvRegistr.setOnClickListener {
            startActivity(Intent(this, FromLogin::class.java))
        }
        btn_input.setOnClickListener {
            if (isETNotEmpty()) {
                val result = MyApp.app?.getDb()?.getAutDao()?.getUser(
                    et_login.text.toString(),
                    et_password.text.toString()
                )
                if (result != null) {
                    startActivity(Intent(this,MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, getString(R.string.input_error), Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, getString(R.string.input_error), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isETNotEmpty(): Boolean {
        val resultLogin = et_login.text.toString().length > 6
        val resultPassword = et_password.text.toString().length > 8

        return resultLogin && resultPassword
    }
}