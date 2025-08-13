package com.optic.ecommerceappmvvm.domain.useCase.team.fixture

import com.optic.ecommerceappmvvm.domain.repository.TeamRepository

class GetNextFixtureTeamUC  constructor(private val repository: TeamRepository) {
    suspend operator fun invoke(teamId: Int) = repository.getNextFixtureTeam(teamId)
}