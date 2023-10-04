package com.example.composedemo.di

import android.content.Context
import androidx.room.Room
import com.example.composedemo.data.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideData(db:AppDatabase) = db.creditCardDao()

    @Singleton
    @Provides
    fun provideAppDB(@ApplicationContext context: Context):AppDatabase =
        Room.databaseBuilder(context,AppDatabase::class.java,"Compose_Demo").fallbackToDestructiveMigration().build()

}