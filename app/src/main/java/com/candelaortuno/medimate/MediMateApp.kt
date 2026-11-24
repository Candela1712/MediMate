package com.candelaortuno.medimate

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate

class MediMateApp : Application() {

    override fun onCreate() {
        super.onCreate()
        val prefs = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val fosc = prefs.getBoolean(KEY_DARK, false)
        AppCompatDelegate.setDefaultNightMode(
            if (fosc) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
        )
    }

    companion object {
        const val PREFS = "medimate_prefs"
        const val KEY_DARK = "tema_fosc"
    }
}