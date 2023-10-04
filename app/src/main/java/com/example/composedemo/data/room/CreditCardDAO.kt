package com.example.composedemo.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.composedemo.mvvm.model.CreditCard
import com.example.composedemo.mvvm.model.EmployDetails


@Dao
interface CreditCardDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserData(creditCard: List<EmployDetails>)
}