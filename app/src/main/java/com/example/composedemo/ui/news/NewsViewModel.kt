package com.example.composedemo.ui.news

import androidx.lifecycle.ViewModel
import com.example.composedemo.domain.usecase.NewsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val newsListUseCase: NewsListUseCase): ViewModel() {

   // newsListUseCase

}