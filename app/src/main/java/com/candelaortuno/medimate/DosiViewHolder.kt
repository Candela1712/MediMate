package com.candelaortuno.medimate

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DosiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvDoseTime: TextView = itemView.findViewById(R.id.tvDoseTime)
    val tvStatusBadge: TextView = itemView.findViewById(R.id.tvStatusBadge)
    val tvMedName: TextView = itemView.findViewById(R.id.tvMedName)
    val tvMedDetail: TextView = itemView.findViewById(R.id.tvMedDetail)
    val btnTake: Button = itemView.findViewById(R.id.btnTake)
}