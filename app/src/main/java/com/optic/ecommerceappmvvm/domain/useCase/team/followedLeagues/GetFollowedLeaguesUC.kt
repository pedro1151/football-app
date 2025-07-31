package com.optic.ecommerceappmvvm.domain.useCase.team.followedLeagues


import com.optic.ecommerceappmvvm.domain.repository.TeamRepository

class GetFollowedLeaguesUC  constructor(private val repository: TeamRepository) {
    suspend operator fun invoke() = repository.getFollowedLeagues()
}