package com.candelaortuno.medimate

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class TodayFragment : Fragment(R.layout.fragment_today) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvDoses = view.findViewById<RecyclerView>(R.id.rvDoses)
        rvDoses.adapter = DosiAdapter(dosesProva())
    }

    private fun dosesProva(): List<Dosi> = listOf(
        Dosi("08:00", "Paracetamol", "1 comprimit · pautat pel metge", true),
        Dosi("14:00", "Ibuprofèn", "Amb menjar", false),
        Dosi("21:00", "Omeprazol", "1 càpsula", false)
    )
}