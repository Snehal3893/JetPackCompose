package com.example.composedemo.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composedemo.mvvm.model.CreditCard
import com.example.composedemo.mvvm.model.EmployDetails

@Database (entities = [EmployDetails::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun creditCardDao() : CreditCardDAO
}