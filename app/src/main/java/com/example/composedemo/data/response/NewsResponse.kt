package com.example.composedemo.data.response

import com.example.composedemo.domain.model.News


data class NewsResponse(
    val status: String?,
    val totalResults: Int?,
    val articles: List<News>?,
) {

}