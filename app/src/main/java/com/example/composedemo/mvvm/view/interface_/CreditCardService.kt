package com.example.composedemo.mvvm.view.interface_

import com.example.composedemo.mvvm.model.CreditCard
import dagger.Provides
import retrofit2.http.GET
import javax.inject.Singleton

interface CreditCardService {
   // @Singleton
    //@Provides
    @GET("credit_cards")
    suspend fun getCreditCards(): List<CreditCard>
}