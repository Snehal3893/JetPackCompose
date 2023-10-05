package com.example.composedemo.mvvm.view.interface_

import com.example.composedemo.data.response.NewsResponse
import com.example.composedemo.mvvm.model.CreditCard
import dagger.Provides
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

interface CreditCardService {
   // @Singleton
    //@Provides
    @GET("credit_cards")
    suspend fun getCreditCards(): List<CreditCard>

   // @GET("products")
    //suspend fun getProducts(): List<>

    @GET("v2/everything")
    suspend fun getNews(
        @Query("q") q: String = "bitcoin",
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 10
    ): Response<NewsResponse>
}