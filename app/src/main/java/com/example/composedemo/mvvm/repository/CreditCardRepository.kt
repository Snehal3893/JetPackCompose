package com.example.composedemo.mvvm.repository

import com.example.composedemo.data.room.CreditCardDAO
import com.example.composedemo.mvvm.model.CreditCard
import com.example.composedemo.mvvm.model.EmployDetails
import com.example.composedemo.mvvm.view.interface_.CreditCardService
import javax.inject.Inject


class CreditCardRepository @Inject constructor(var creditCardService : CreditCardService, val creditCardDAO: CreditCardDAO){
    //private val creditCardService = RetrofitInstance.creditCardService

    suspend fun getCreditCards(): List<CreditCard> {
        return creditCardService.getCreditCards()
    }

     suspend fun insertData(creditCard: List<EmployDetails>) = creditCardDAO.inserData(creditCard)

    suspend fun fetchEmpData():List<EmployDetails>{
        return creditCardDAO.fetchEmpDetails()
    }
}