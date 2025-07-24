package com.optic.ecommerceappmvvm.domain.useCase.team.fixture


import com.optic.ecommerceappmvvm.domain.repository.TeamRepository

class GetFixtureFollowedTeamsUC  constructor(private val repository: TeamRepository) {
    suspend operator fun invoke(season: Int, date: String) = repository.getFixtureFollowedTeams(season, date)
}