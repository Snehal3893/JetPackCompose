package com.example.composedemo.mvvm.model

data class CreditCard(
    val id: String,
    val bank: String,
    val number: String,
    val cvv: String,
    val type: String
)