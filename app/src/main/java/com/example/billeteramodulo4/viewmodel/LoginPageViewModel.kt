package com.example.billeteramodulo4.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginPageViewModel : ViewModel() {

    private val _email = MutableLiveData<String?>()
    val email: LiveData<String?> get() = _email

    private val _password = MutableLiveData<String?>()
    val password: LiveData<String?> get() = _password

    private val _validarUsuario = MutableLiveData<Boolean>()
    val validarUsuario: LiveData<Boolean> get() = _validarUsuario


    fun validarCorreo(email: String, password: String) {
        _email.value = email
        _password.value = password
        validarUsuario()
    }

    private fun validarUsuario() {
        _validarUsuario.value = !(email.value.isNullOrEmpty() || password.value.isNullOrEmpty())
    }

}