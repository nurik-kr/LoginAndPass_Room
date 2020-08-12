package com.example.fightwithroom.ui

import MainActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fightwithroom.Data.LoginModel
import com.example.fightwithroom.MyApp
import com.example.fightwithroom.R
import kotlinx.android.synthetic.main.activity_from_login.*

class FromLogin : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_from_login)
        setupListeners()
    }

    private fun setupListeners() {
        btnEnter.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            if (isETNotEmpty() && isPasswordSimilar()) {
                MyApp.app?.getDb()?.getAutDao()?.addUser(
                    LoginModel(
                        id = 1,
                        login = etLogin.text.toString(),
                        password = etPassword.text.toString()
                    )
                )
                startActivity(Intent(this,MainActivity::class.java))
            } else {
                Toast.makeText(this, getString(R.string.input_error), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isPasswordSimilar(): Boolean {
        val result = etPassword.text.toString() == etPasswordRepeat.text.toString()
        return result
    }

    private fun isETNotEmpty(): Boolean {
        val resultLogin = etLogin.text.toString().length > 6
        val resultPassword = etPassword.text.toString().length > 8
        val resultPasswordRepeat = etPasswordRepeat.text.toString().length > 8

        return resultLogin && resultPassword && resultPasswordRepeat
    }
}