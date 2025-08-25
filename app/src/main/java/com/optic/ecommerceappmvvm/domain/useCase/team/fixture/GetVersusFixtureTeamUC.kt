package com.optic.ecommerceappmvvm.domain.useCase.team.fixture

import com.optic.ecommerceappmvvm.domain.repository.TeamRepository

class GetVersusFixtureTeamUC  constructor(private val repository: TeamRepository) {
    suspend operator fun invoke(
        teamOneId:Int,
        teamTwoId: Int,
        leagueId: Int,
        season: Int
        ) = repository.getFixtureVersus(teamOneId, teamTwoId, leagueId,season)
}