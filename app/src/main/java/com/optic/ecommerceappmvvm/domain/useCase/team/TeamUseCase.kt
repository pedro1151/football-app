package com.optic.ecommerceappmvvm.domain.useCase.team

data class TeamUseCase(
    val getallTeamUseCase: GetallTeamUseCase,
    val getPlayersUseCase: GetPlayersUseCase,
    val getPlayerStatsUseCase: GetPlayerStatsUseCase,
    val getLeaguesUseCase    : GetLeaguesUseCase,

    // UC PLAYER SEGUIDOS
    val getFollowedPlayersUC   : GetFollowedPlayersUC,
    val createFollowedPlayerUC   : CreateFollowedPlayerUC,
    val deleteFollowedPlayerUC   : DeleteFollowedPlayerUC,

)
