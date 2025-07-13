package com.optic.ecommerceappmvvm.domain.useCase.team


import com.optic.ecommerceappmvvm.domain.repository.TeamRepository

class CreateFollowedPlayerUC  constructor(private val repository: TeamRepository) {
    suspend operator fun invoke(playerId: Int) = repository.createFollowedPlayer(playerId)
}