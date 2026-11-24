package com.candelaortuno.medimate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {

    private val _errorNom = MutableLiveData<Int?>()
    val errorNom: LiveData<Int?> = _errorNom

    private val _errorEmail = MutableLiveData<Int?>()
    val errorEmail: LiveData<Int?> = _errorEmail

    private val _errorPassword = MutableLiveData<Int?>()
    val errorPassword: LiveData<Int?> = _errorPassword

    private val _registreCorrecte = MutableLiveData<Boolean>()
    val registreCorrecte: LiveData<Boolean> = _registreCorrecte

    fun validar(nom: String, email: String, password: String) {
        val resultatNom = comprovarNom(nom)
        val resultatEmail = comprovarEmail(email)
        val resultatPassword = comprovarPassword(password)
        _errorNom.value = resultatNom
        _errorEmail.value = resultatEmail
        _errorPassword.value = resultatPassword
        _registreCorrecte.value =
            resultatNom == null && resultatEmail == null && resultatPassword == null
    }

    private fun comprovarNom(nom: String): Int? {
        val netejat = nom.trim()
        if (netejat.isEmpty()) return R.string.error_nom_buit
        if (netejat.length < 2) return R.string.error_nom_curt
        if (!netejat.all { it.isLetter() || it == ' ' }) return R.string.error_nom_invalid
        return null
    }

    private fun comprovarEmail(email: String): Int? {
        if (email.isBlank()) return R.string.error_email_buit
        val arroba = email.indexOf("@")
        val punt = email.lastIndexOf(".")
        val unaArroba = email.count { it == '@' } == 1
        if (email.contains(" ") || !unaArroba || arroba < 1 || punt < arroba + 2 || punt == email.length - 1) {
            return R.string.error_email_invalid
        }
        return null
    }

    private fun comprovarPassword(password: String): Int? {
        if (password.isEmpty()) return R.string.error_password_buit
        if (password.length < 8) return R.string.error_password_curta
        return null
    }
}