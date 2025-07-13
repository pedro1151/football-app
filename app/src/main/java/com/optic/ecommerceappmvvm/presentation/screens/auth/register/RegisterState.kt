package com.optic.ecommerceappmvvm.presentation.screens.auth.register

data class RegisterState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = ""
)
