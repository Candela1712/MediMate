package com.candelaortuno.medimate

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.materialswitch.MaterialSwitch

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val switchDark = view.findViewById<MaterialSwitch>(R.id.switchDarkTheme)
        val tvState = view.findViewById<TextView>(R.id.tvDarkThemeState)
        val prefs = requireContext().getSharedPreferences(MediMateApp.PREFS, Context.MODE_PRIVATE)

        val fosc = prefs.getBoolean(MediMateApp.KEY_DARK, false)
        switchDark.isChecked = fosc
        mostrarEstat(tvState, fosc)

        switchDark.setOnCheckedChangeListener { _, activat ->
            prefs.edit().putBoolean(MediMateApp.KEY_DARK, activat).apply()
            mostrarEstat(tvState, activat)
            AppCompatDelegate.setDefaultNightMode(
                if (activat) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
            )
        }
    }

    private fun mostrarEstat(tvState: TextView, activat: Boolean) {
        if (activat) {
            tvState.setText(R.string.settings_switch_on)
            tvState.setTextColor(ContextCompat.getColor(requireContext(), R.color.medimate_primary))
        } else {
            tvState.setText(R.string.settings_switch_off)
            tvState.setTextColor(ContextCompat.getColor(requireContext(), R.color.medimate_text_secondary))
        }
    }
}