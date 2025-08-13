package com.optic.ecommerceappmvvm.domain.useCase.team.fixture

import com.optic.ecommerceappmvvm.domain.repository.TeamRepository

class GetTopFiveFixtureTeamUC  constructor(private val repository: TeamRepository) {
    suspend operator fun invoke(teamId: Int) = repository.getTopFiveFixtureTeam(teamId)
}