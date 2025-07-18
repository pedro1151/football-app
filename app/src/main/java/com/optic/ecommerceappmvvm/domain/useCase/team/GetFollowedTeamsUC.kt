package com.optic.ecommerceappmvvm.domain.useCase.team

import com.optic.ecommerceappmvvm.domain.repository.TeamRepository

class GetFollowedTeamsUC constructor(private val repository: TeamRepository) {
    suspend operator fun invoke() = repository.getFollowedTeams()
}