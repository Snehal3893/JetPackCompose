package com.example.composedemo.mvvm.view.`interface`

import com.example.composedemo.mvvm.model.CreditCard
import retrofit2.http.GET

interface CreditCardService {
    @GET("credit_cards")
    suspend fun getCreditCards(): List<CreditCard>
}