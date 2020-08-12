package com.example.fightwithroom

import android.app.Application
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import com.example.fightwithroom.Data.Database
import com.example.fightwithroom.Data.LoginModel

class MyApp : Application() {

    private var db: Database? = null

    override fun onCreate() {
        super.onCreate()
        app = this

        db = databaseBuilder(applicationContext, Database::class.java, "MY_DATABASE")
            .allowMainThreadQueries()
            .build()
    }

    fun getDb(): Database? = db

    companion object {
        var app: MyApp? = null
    }
}