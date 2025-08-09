package com.optic.ecommerceappmvvm.domain.useCase.team.equipos

import com.optic.ecommerceappmvvm.domain.model.AuthResponse
import com.optic.ecommerceappmvvm.domain.repository.AuthRepository
import com.optic.ecommerceappmvvm.domain.repository.TeamRepository

class GetTeamByIdUC constructor(private val repository: TeamRepository) {
    suspend operator fun invoke(teamId: Int) = repository.getTeamById(teamId)
}