package com.optic.ecommerceappmvvm.domain.useCase.team

import com.optic.ecommerceappmvvm.domain.model.AuthResponse
import com.optic.ecommerceappmvvm.domain.repository.AuthRepository
import com.optic.ecommerceappmvvm.domain.repository.TeamRepository

class GetLeaguesUseCase constructor(private val repository: TeamRepository) {
    suspend operator fun invoke(name: String, type: String, countryName: String) = repository.getLeagues(name, type,countryName)
}