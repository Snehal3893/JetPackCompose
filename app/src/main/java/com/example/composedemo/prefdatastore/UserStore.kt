package com.example.composedemo.prefdatastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserStore(private val context: Context) {
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

    suspend fun saveToken(name: String,pwd: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_NAME_KEY] = name
        }
        context.dataStorePwd.edit { preferences ->
            preferences[USER_PWD_KEY] = pwd
        }
    }
}