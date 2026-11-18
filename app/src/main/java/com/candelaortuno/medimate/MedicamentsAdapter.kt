package com.candelaortuno.medimate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MedicamentsAdapter(
    private val medicaments: List<Medicament>,
    private val onModificar: (Medicament) -> Unit,
    private val onEliminar: (Medicament) -> Unit
) : RecyclerView.Adapter<MedicamentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicamentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_medicament, parent, false)
        return MedicamentViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedicamentViewHolder, position: Int) {
        val medicament = medicaments[position]
        holder.tvMedName.text = medicament.nom
        holder.tvReason.text = medicament.motiu
        holder.tvSchedule.text = medicament.hora
        holder.tvNote.text = medicament.nota

        holder.itemView.setOnClickListener { onModificar(medicament) }
        holder.itemView.setOnLongClickListener {
            onEliminar(medicament)
            true
        }
    }

    override fun getItemCount(): Int = medicaments.size
}