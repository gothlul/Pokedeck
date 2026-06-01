package com.pokedeck.core.controllers

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.mutableStateOf
import com.pokedeck.core.models.User
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.pokedeck.R

class Controller {
    companion object{
        var user by mutableStateOf(
            User(
                "Teste",
                "",
                "",
                "",
                "",
                "",
                R.drawable.charizard,
                10.0
            )
        )
        var token by mutableStateOf("")

        private fun getPrefs(context: Context): SharedPreferences {
            val masterKey = MasterKey.Builder(context)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build()

            return EncryptedSharedPreferences.create(
                context,
                "secure_prefs",
                masterKey,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
        }

        fun login(context: Context, email: String, password: String) {
            val prefs = getPrefs(context)

            val savedToken = prefs.getString("auth_token", null)

            if (savedToken != null) {
                token = savedToken
            } else {
                val newToken = Repository.login(email, password)

                prefs.edit().putString("auth_token", newToken).apply()
                token = newToken

            }
        }

        fun logout(context: Context) {
            getPrefs(context).edit().remove("auth_token").apply()
            token = ""
        }
    }

}