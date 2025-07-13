package com.optic.ecommerceappmvvm.domain.useCase.auth

import com.optic.ecommerceappmvvm.domain.model.User
import com.optic.ecommerceappmvvm.domain.repository.AuthRepository

class RegisterUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(user: User) =  repository.register(user);

}