package com.example.composedemo.di

import com.example.composedemo.mvvm.view.`interface`.CreditCardService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object RetrofitInstance {
    private const val BASE_URL = "https://random-data-api.com/api/v2/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

   // @Provides
   /* val creditCardService: CreditCardService by lazy {
        retrofit.create(CreditCardService::class.java)
    }*/
    @Provides
    fun creditCardService(retrofit: Retrofit):CreditCardService = retrofit.create(CreditCardService::class.java)
}