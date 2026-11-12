package com.candelaortuno.medimate

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MedicamentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvMedName: TextView = itemView.findViewById(R.id.tvMedName)
    val tvReason: TextView = itemView.findViewById(R.id.tvReason)
    val tvSchedule: TextView = itemView.findViewById(R.id.tvSchedule)
    val tvNote: TextView = itemView.findViewById(R.id.tvNote)
}