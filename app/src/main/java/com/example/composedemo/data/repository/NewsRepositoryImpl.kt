package com.example.composedemo.data.repository
import com.example.composedemo.data.RequestException
import com.example.composedemo.domain.model.News
import com.example.composedemo.mvvm.view.interface_.CreditCardService
import java.net.HttpURLConnection
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsService: CreditCardService
)  {

    private val cachedList: MutableList<News> = mutableListOf()

     suspend fun getNewsList(): Result<List<News>> {
        val apiResponse = newsService.getNews().body()
        if (apiResponse?.status == "ok") {
            val newsList = apiResponse.articles ?: emptyList()
            cachedList.addAll(newsList)
            return Result.success(newsList)
        }

        return Result.failure(
            RequestException(
                code = HttpURLConnection.HTTP_INTERNAL_ERROR,
                message = "An error occurred!"
            )
        )
    }

     suspend fun getNewsDetail(id: Int): Result<News> {
        return cachedList.find { it.id == id }?.let { news ->
            Result.success(news)
        } ?: run {
            Result.failure(Exception("An error occurred when get new detail"))
        }
    }
}