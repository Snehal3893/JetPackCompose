package com.example.composedemo.ui.home

import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composedemo.mvvm.model.Details
import com.example.composedemo.mvvm.repository.CreditCardRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val repository : CreditCardRepository) : ViewModel() {

    fun insertData(){

        viewModelScope.launch(Dispatchers.IO) {

            repository.insertData(Details.EmployDetailsList)

        }
    }

}