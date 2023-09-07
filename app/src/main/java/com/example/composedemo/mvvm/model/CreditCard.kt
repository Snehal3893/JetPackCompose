package com.example.composedemo.mvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CreditCard(
  @PrimaryKey  val id: String,
  @ColumnInfo(name = "bank")  val bank: String,
  @ColumnInfo(name = "number")  val number: String,
  @ColumnInfo(name = "cvv")  val cvv: String,
  @ColumnInfo(name = "type")  val type: String
)