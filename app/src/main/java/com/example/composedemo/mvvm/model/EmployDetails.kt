package com.example.composedemo.mvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EmployDetails(@PrimaryKey val id: Int,
                         @ColumnInfo(name = "title") val title: String,
                         @ColumnInfo(name = "sex") val sex: String,
                         @ColumnInfo(name = "age") val age: Int,
                         @ColumnInfo(name = "ImageId") val ImageId: Int = 0)