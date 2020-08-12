package com.example.fightwithroom.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fightwithroom.MyApp

@Dao
interface AutDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: LoginModel)

    @Query("SELECT *  FROM LoginModel WHERE login =:loginText AND password=:passwordText")
    fun getUser(loginText: String, passwordText: String): LoginModel

    @Query("SELECT * FROM LoginModel")
    fun getAllUsers(): List<LoginModel>
}