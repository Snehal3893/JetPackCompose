package com.example.composedemo.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class News(
    @PrimaryKey val iD: Int,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "content") val content: String?,
    @ColumnInfo(name = "author") val author: String?,
    @ColumnInfo(name = "urlToImage") val urlToImage: String?,
    @ColumnInfo(name = "url") val url: String
) {
    val id: Int
        get() = url.hashCode()
}