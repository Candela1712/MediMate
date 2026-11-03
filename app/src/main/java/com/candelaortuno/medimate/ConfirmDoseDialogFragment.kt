package com.candelaortuno.medimate

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialogFragment

class ConfirmDoseDialogFragment : AppCompatDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.dialog_confirm_dose, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = arguments?.getString("name") ?: "Paracetamol"
        val time = arguments?.getString("time") ?: "08:00"
        val dose = arguments?.getString("dose") ?: "1 comprimit"

        view.findViewById<TextView>(R.id.tvConfirmTitle).text =
            getString(R.string.confirm_dose_title, name)
        view.findViewById<TextView>(R.id.tvConfirmDetails).text =
            getString(R.string.confirm_dose_details, time, dose)

        view.findViewById<View>(R.id.btnConfirmYes).setOnClickListener { dismiss() }
        view.findViewById<View>(R.id.btnConfirmNo).setOnClickListener { dismiss() }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.apply {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }
    }

    companion object {
        fun newInstance(name: String, time: String, dose: String) =
            ConfirmDoseDialogFragment().apply {
                arguments = Bundle().apply {
                    putString("name", name)
                    putString("time", time)
                    putString("dose", dose)
                }
            }
    }
}