package com.optic.ecommerceappmvvm.domain.useCase.auth

import com.optic.ecommerceappmvvm.domain.repository.AuthRepository

class GetSessionDataUseCase constructor(private val repository: AuthRepository) {
    operator fun invoke() = repository.getSessionData()
}