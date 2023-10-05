package com.example.composedemo.ui.home

import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composedemo.mvvm.model.CreditCard
import com.example.composedemo.mvvm.model.Details
import com.example.composedemo.mvvm.model.EmployDetails
import com.example.composedemo.mvvm.repository.CreditCardRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val repository : CreditCardRepository) : ViewModel() {
    val _empDetails = mutableListOf<List<EmployDetails>>()
   // val empDetails: LiveData<List<EmployDetails>> = _empDetails

    fun insertData(){

        viewModelScope.launch(Dispatchers.IO) {

            repository.insertData(Details.EmployDetailsList)

        }
    }

    fun fetchEmpDetails(){
        viewModelScope.launch(Dispatchers.IO) {
            _empDetails.add(repository.fetchEmpData())
         //   repository.fetchEmpData()
        }
       // return _empDetails
    }

}