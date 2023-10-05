package com.example.composedemo.data

class RequestException(val code: Int, message: String) : Throwable(message)