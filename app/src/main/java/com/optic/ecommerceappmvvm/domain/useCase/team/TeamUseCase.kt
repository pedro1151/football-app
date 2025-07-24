package com.optic.ecommerceappmvvm.domain.useCase.team

import com.optic.ecommerceappmvvm.domain.useCase.team.fixture.GetFixtureFollowedTeamsUC

data class TeamUseCase(
    val getallTeamUseCase: GetallTeamUseCase,
    val getPlayersUseCase: GetPlayersUseCase,
    val getPlayerStatsUseCase: GetPlayerStatsUseCase,
    val getLeaguesUseCase    : GetLeaguesUseCase,

    // UC PLAYER SEGUIDOS
    val getFollowedPlayersUC   : GetFollowedPlayersUC,
    val createFollowedPlayerUC   : CreateFollowedPlayerUC,
    val deleteFollowedPlayerUC   : DeleteFollowedPlayerUC,

    // UC TEAM SEGUIDOS

    val getFollowedTeamsUC   : GetFollowedTeamsUC,
    val createFollowedTeamUC   : CreateFollowedTeamUC,
    val deleteFollowedTeamUC  : DeleteFollowedTeamUC,

    // matches ( FIxture)
    val getFixtureFollowedTeamsUC : GetFixtureFollowedTeamsUC

)
