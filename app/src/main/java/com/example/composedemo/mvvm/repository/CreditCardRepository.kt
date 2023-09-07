package com.example.composedemo.mvvm.repository

import com.example.composedemo.mvvm.model.CreditCard
import com.example.composedemo.mvvm.view.`interface`.CreditCardService
import javax.inject.Inject


class CreditCardRepository @Inject constructor(var creditCardService : CreditCardService){
    //private val creditCardService = RetrofitInstance.creditCardService

    suspend fun getCreditCards(): List<CreditCard> {
        return creditCardService.getCreditCards()
    }
}