package com.example.composedemo.data.prefdatastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//@Module
//@InstallIn(SingletonComponent::class)
 class UserStore( val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("user_name")
        private val Context.dataStorePwd: DataStore<Preferences> by preferencesDataStore("user_pwd")
        private val USER_NAME_KEY = stringPreferencesKey("user_name")
        private val USER_PWD_KEY = stringPreferencesKey("user_pwd")
    }

    val getAccessToken: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[USER_NAME_KEY] ?: ""
    }
    val getPwd:Flow<String> = context.dataStorePwd.data.map { preferences ->
        preferences[USER_PWD_KEY]?: ""
    }

  //@Provides
    suspend fun saveToken(name: String,pwd: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_NAME_KEY] = name
        }
        context.dataStorePwd.edit { preferences ->
            preferences[USER_PWD_KEY] = pwd
        }
    }
}