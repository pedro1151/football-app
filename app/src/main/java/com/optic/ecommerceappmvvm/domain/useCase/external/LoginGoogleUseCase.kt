package com.optic.ecommerceappmvvm.domain.useCase.external

import com.optic.ecommerceappmvvm.domain.repository.ExternalRepository

class LoginGoogleUseCase(private val repository: ExternalRepository) {

    suspend operator fun invoke(id_token: String) = repository.login(id_token)

}