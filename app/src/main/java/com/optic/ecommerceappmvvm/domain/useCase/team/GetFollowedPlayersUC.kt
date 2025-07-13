package com.optic.ecommerceappmvvm.domain.useCase.team

import com.optic.ecommerceappmvvm.domain.repository.TeamRepository

class GetFollowedPlayersUC constructor(private val repository: TeamRepository) {
    suspend operator fun invoke() = repository.getFollowedPlayers()
}