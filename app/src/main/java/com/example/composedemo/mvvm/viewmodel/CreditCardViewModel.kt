package com.example.composedemo.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composedemo.mvvm.model.CreditCard
import com.example.composedemo.mvvm.repository.CreditCardRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreditCardViewModel @Inject constructor(val repository : CreditCardRepository) : ViewModel() {
   // private val repository = CreditCardRepository()

     val _creditCards = MutableLiveData<List<CreditCard>>()
    val creditCards: LiveData<List<CreditCard>> = _creditCards

    fun fetchCreditCards() {
        viewModelScope.launch {
            try {
                val cards = repository.getCreditCards()
                _creditCards.value = cards
                //repository.insertData(cards)
            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            }
        }
    }
}