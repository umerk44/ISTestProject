package com.test.istestprojectapplication.core

import android.content.Context
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

class SessionManager(context: Context) {

    private val sharedPreferences = EncryptedSharedPreferences.create(
        context,
        FILE,
        MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build(),
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

     fun saveToken(token: String?) {
        sharedPreferences.edit {
            putString(TOKEN, token)
            commit()
        }
    }

    fun saveUserName(name : String?) {
        sharedPreferences.edit {
            putString(USER_NAME, name)
            commit()
        }
    }

    fun getToken(): String? = sharedPreferences.getString(TOKEN, null)

    fun getUserName() : String? = sharedPreferences.getString(USER_NAME, null)

    companion object {
        const val FILE = "is_secure_pref"
        const val TOKEN = "token"
        const val USER_NAME = "username"
    }
}