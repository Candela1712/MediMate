package com.candelaortuno.medimate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class DosiAdapter(
    private val doses: List<Dosi>
) : RecyclerView.Adapter<DosiViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DosiViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dose, parent, false)
        return DosiViewHolder(view)
    }

    override fun onBindViewHolder(holder: DosiViewHolder, position: Int) {
        val dosi = doses[position]
        val context = holder.itemView.context
        holder.tvDoseTime.text = dosi.hora
        holder.tvMedName.text = dosi.nom
        holder.tvMedDetail.text = dosi.detall

        if (dosi.pres) {
            holder.tvStatusBadge.setText(R.string.status_taken)
            holder.tvStatusBadge.setBackgroundResource(R.drawable.bg_badge_taken)
            holder.tvStatusBadge.setTextColor(ContextCompat.getColor(context, R.color.medimate_primary))
            holder.btnTake.visibility = View.GONE
        } else {
            holder.tvStatusBadge.setText(R.string.status_pending)
            holder.tvStatusBadge.setBackgroundResource(R.drawable.bg_badge_pending)
            holder.tvStatusBadge.setTextColor(ContextCompat.getColor(context, R.color.medimate_warning))
            holder.btnTake.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int = doses.size
}