package com.candelaortuno.medimate

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MedicamentsFragment : Fragment(R.layout.fragment_medicaments) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvMedicaments = view.findViewById<RecyclerView>(R.id.rvMedicaments)
        rvMedicaments.layoutManager = LinearLayoutManager(requireContext())
        rvMedicaments.adapter = MedicamentsAdapter(
            medicamentsProva(),
            onModificar = { medicament ->
                Log.i("MediMate", "Modificar: ${medicament.nom}")
                Toast.makeText(requireContext(), "Modificar ${medicament.nom}", Toast.LENGTH_SHORT).show()
            },
            onEliminar = { medicament ->
                Log.i("MediMate", "Eliminar: ${medicament.nom}")
                Toast.makeText(requireContext(), "Eliminar ${medicament.nom}", Toast.LENGTH_SHORT).show()
            }
        )

        view.findViewById<View>(R.id.btnAddMed).setOnClickListener {
            Log.i("MediMate", "Afegir medicament")
            Toast.makeText(requireContext(), "Afegir medicament", Toast.LENGTH_SHORT).show()
        }
    }

    private fun medicamentsProva(): List<Medicament> = listOf(
        Medicament("Paracetamol", "Dolor", "08:00", "1 comprimit"),
        Medicament("Ibuprofèn", "Mal de cap", "14:00", "Amb menjar"),
        Medicament("Omeprazol", "Estómac", "09:00", "En dejú"),
        Medicament("Paracetamol", "Febre", "21:00", "1 comprimit")
    )
}