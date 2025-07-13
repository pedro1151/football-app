package com.optic.ecommerceappmvvm.domain.useCase.auth

import com.optic.ecommerceappmvvm.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)

}