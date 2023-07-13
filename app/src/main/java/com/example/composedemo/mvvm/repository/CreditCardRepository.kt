package com.example.composedemo.mvvm.repository

import com.example.composedemo.mvvm.model.CreditCard
import com.example.composedemo.mvvm.remote.RetrofitInstance

class CreditCardRepository {
    private val creditCardService = RetrofitInstance.creditCardService

    suspend fun getCreditCards(): List<CreditCard> {
        return creditCardService.getCreditCards()
    }
}