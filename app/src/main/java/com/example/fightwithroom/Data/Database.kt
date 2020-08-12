package com.example.fightwithroom.Data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LoginModel::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun getAutDao(): AutDao
}