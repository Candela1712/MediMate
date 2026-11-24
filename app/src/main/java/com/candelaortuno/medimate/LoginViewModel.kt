package com.candelaortuno.medimate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _errorEmail = MutableLiveData<Int?>()
    val errorEmail: LiveData<Int?> = _errorEmail

    private val _errorPassword = MutableLiveData<Int?>()
    val errorPassword: LiveData<Int?> = _errorPassword

    private val _loginCorrecte = MutableLiveData<Boolean>()
    val loginCorrecte: LiveData<Boolean> = _loginCorrecte

    fun validar(email: String, password: String) {
        val resultatEmail = comprovarEmail(email)
        val resultatPassword = comprovarPassword(password)
        _errorEmail.value = resultatEmail
        _errorPassword.value = resultatPassword
        _loginCorrecte.value = resultatEmail == null && resultatPassword == null
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