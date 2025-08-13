package com.optic.ecommerceappmvvm.domain.useCase.team

import com.optic.ecommerceappmvvm.domain.useCase.team.equipos.GetTeamByIdUC
import com.optic.ecommerceappmvvm.domain.useCase.team.fixture.GetFixtureFollowedTeamsUC
import com.optic.ecommerceappmvvm.domain.useCase.team.fixture.GetFixtureTeamUC
import com.optic.ecommerceappmvvm.domain.useCase.team.fixture.GetNextFixtureTeamUC
import com.optic.ecommerceappmvvm.domain.useCase.team.fixture.GetTopFiveFixtureTeamUC
import com.optic.ecommerceappmvvm.domain.useCase.team.followedLeagues.CreateFollowedLeagueUC
import com.optic.ecommerceappmvvm.domain.useCase.team.followedLeagues.DeleteFollowedLeagueUC
import com.optic.ecommerceappmvvm.domain.useCase.team.followedLeagues.GetFollowedLeaguesUC

data class TeamUseCase(

    // teams
    val getallTeamUseCase: GetallTeamUseCase,
    val getTeamByIdUC : GetTeamByIdUC,

    //players
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
    val getFixtureFollowedTeamsUC : GetFixtureFollowedTeamsUC,
    val getFixtureTeamUC : GetFixtureTeamUC,
    val getNextFixtureTeamUC : GetNextFixtureTeamUC,
    val getTopFiveFixtureTeamUC : GetTopFiveFixtureTeamUC,


    // UC LEAGUES SEGUIDOS

    val getFollowedLeaguesUC   : GetFollowedLeaguesUC,
    val createFollowedLeagueUC   : CreateFollowedLeagueUC,
    val deleteFollowedLeagueUC  : DeleteFollowedLeagueUC

)
