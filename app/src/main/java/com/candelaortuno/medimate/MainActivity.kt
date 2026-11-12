package com.candelaortuno.medimate

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_today -> {
                    carregarFragment(TodayFragment())
                    true
                }
                R.id.nav_meds -> {
                    carregarFragment(MedicamentsFragment())
                    true
                }
                R.id.nav_caregiver -> {
                    carregarFragment(CaregiverFragment())
                    true
                }
                R.id.nav_settings -> {
                    carregarFragment(SettingsFragment())
                    true
                }
                else -> false
            }
        }
        if (savedInstanceState == null) {
            bottomNav.selectedItemId = R.id.nav_today
        }
    }
    private fun carregarFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
    }
}