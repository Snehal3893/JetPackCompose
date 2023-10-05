package com.example.composedemo.domain.usecase

import com.example.composedemo.data.repository.NewsRepositoryImpl
import com.example.composedemo.domain.model.News
import javax.inject.Inject

class NewsListUseCase @Inject constructor(private val newsRepositoryImpl: NewsRepositoryImpl) {
    suspend fun getNewsList(): Result<List<News>> {
        return newsRepositoryImpl.getNewsList()
    }
}