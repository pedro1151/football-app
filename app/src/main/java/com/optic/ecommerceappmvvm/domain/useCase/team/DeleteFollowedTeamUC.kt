package com.optic.ecommerceappmvvm.domain.useCase.team


import com.optic.ecommerceappmvvm.domain.repository.TeamRepository

class DeleteFollowedTeamUC  constructor(private val repository: TeamRepository) {
    suspend operator fun invoke(teamId: Int) = repository.deleteFollowedTeam(teamId)
}