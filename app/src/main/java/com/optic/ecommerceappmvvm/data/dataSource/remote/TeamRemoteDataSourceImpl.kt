package com.optic.ecommerceappmvvm.data.dataSource.remote

import com.optic.ecommerceappmvvm.data.dataSource.remote.service.TeamService
import com.optic.ecommerceappmvvm.domain.model.League.League
import com.optic.ecommerceappmvvm.domain.model.player.Player
import com.optic.ecommerceappmvvm.domain.model.Team
import com.optic.ecommerceappmvvm.domain.model.fixture.FixtureResponse
import com.optic.ecommerceappmvvm.domain.model.followed.FollowedLeagueRequest
import com.optic.ecommerceappmvvm.domain.model.followed.FollowedLeagueResponse
import com.optic.ecommerceappmvvm.domain.model.followed.FollowedPlayerRequest
import com.optic.ecommerceappmvvm.domain.model.followed.FollowedPlayerResponse
import com.optic.ecommerceappmvvm.domain.model.followed.FollowedTeamRequest
import com.optic.ecommerceappmvvm.domain.model.followed.FollowedTeamResponse
import com.optic.ecommerceappmvvm.domain.model.player.stats.PlayerWithStats
import com.optic.ecommerceappmvvm.domain.model.response.DefaultResponse
import retrofit2.Response

class TeamRemoteDataSourceImpl (private val teamService: TeamService): TeamRemoteDataSource {
    override suspend fun getAll(): Response<List<Team>> = teamService.getTeams()
    override suspend fun getPlayers(): Response<List<Player>> = teamService.getPlayers()
    override suspend fun getPlayerStats(playerId: Int): Response<PlayerWithStats> = teamService.getPlayerStats(playerId)
    override suspend fun getLeagues(
        name: String,
        type: String,
        countryName: String
    ): Response<List<League>> = teamService.getLeagues(name, type, countryName)

    override suspend fun createFollowedPlayer(playerId: Int): Response<FollowedPlayerResponse> = teamService.createFollowedPlayer(FollowedPlayerRequest( playerId))

    override suspend fun getFollowedPlayers(): Response<List<Player>> = teamService.getFollowedPlayers()
    override suspend fun deleteFollowedPlayer(playerId: Int): Response<DefaultResponse> = teamService.deleteFollowedPlayer(playerId)

    // FOLLOWED TEAMS
    override suspend fun createFollowedTeam(teamId: Int): Response<FollowedTeamResponse>  = teamService.createFollowedTeam(
        FollowedTeamRequest(teamId)
    )

    override suspend fun getFollowedTeams(): Response<List<Team>> = teamService.getFollowedTeams()

    override suspend fun deleteFollowedTeam(teamId: Int): Response<DefaultResponse> = teamService.deleteFollowedTeam(teamId)


    // FOLLOWED LEAGUES
    override suspend fun createFollowedLeague(leagueId: Int): Response<FollowedLeagueResponse> = teamService.createFollowedLeague(
        FollowedLeagueRequest(leagueId)
    )

    override suspend fun getFollowedLeagues(): Response<List<League>> = teamService.getFollowedLeagues()

    override suspend fun deleteFollowedLeague(leagueId: Int): Response<DefaultResponse> = teamService.deleteFollowedLeague(leagueId)

    // MATCHES ( FIXTURES)
    override suspend fun getFixtureFollowedTeams(
        season: Int,
        date: String
    ): Response<List<FixtureResponse>> = teamService.getFixtureFollowedTeams(season, date)


}