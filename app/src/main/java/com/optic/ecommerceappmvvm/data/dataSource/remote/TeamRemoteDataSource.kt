package com.optic.ecommerceappmvvm.data.dataSource.remote

import com.optic.ecommerceappmvvm.domain.model.League.League
import com.optic.ecommerceappmvvm.domain.model.player.Player
import com.optic.ecommerceappmvvm.domain.model.Team
import com.optic.ecommerceappmvvm.domain.model.fixture.FixtureResponse
import com.optic.ecommerceappmvvm.domain.model.followed.FollowedLeagueResponse
import com.optic.ecommerceappmvvm.domain.model.followed.FollowedPlayerResponse
import com.optic.ecommerceappmvvm.domain.model.followed.FollowedTeamResponse
import com.optic.ecommerceappmvvm.domain.model.player.stats.PlayerWithStats
import com.optic.ecommerceappmvvm.domain.model.response.DefaultResponse
import com.optic.ecommerceappmvvm.domain.model.team.TeamResponse
import retrofit2.Response

interface TeamRemoteDataSource {
  /* tambien en este archivo de datasource, se responde con Response de retrofit,
   esta aclarcion es util, ya que en las implementaciones se utiliza FLow
   */
    // Teams
    suspend fun getAll(): Response<List<Team>>
    suspend fun getTeamById(teamId: Int): Response<TeamResponse>

    //Players
    suspend fun getPlayers(): Response<List<Player>>
    suspend fun getPlayerStats(playerId: Int): Response<PlayerWithStats>
    suspend fun getLeagues(name: String, type: String, countryName: String): Response<List<League>>

    //PLAYER SEGUIDOS
    suspend fun createFollowedPlayer(playerId: Int): Response<FollowedPlayerResponse>
    suspend fun getFollowedPlayers(): Response<List<Player>>
    suspend fun deleteFollowedPlayer(playerId: Int): Response<DefaultResponse>


  //TEAM SEGUIDOS
    suspend fun createFollowedTeam(teamId: Int): Response<FollowedTeamResponse>
    suspend fun getFollowedTeams(): Response<List<Team>>
    suspend fun deleteFollowedTeam(teamId: Int): Response<DefaultResponse>


  //PARA SEGUIR LIGAS
  suspend fun createFollowedLeague(leagueId: Int): Response<FollowedLeagueResponse>
  suspend fun getFollowedLeagues(): Response<List<League>>
  suspend fun deleteFollowedLeague(leagueId: Int): Response<DefaultResponse>


    // FIXTURES
    suspend fun getFixtureFollowedTeams(season: Int, date: String): Response<List<FixtureResponse>>
    //Teams
    suspend fun getFixtureTeam(teamId: Int): Response<List<FixtureResponse>>
    suspend fun getNextFixtureTeam(teamId: Int): Response<FixtureResponse>
    suspend fun getTopFiveFixtureTeam(teamId: Int): Response<List<FixtureResponse>>


}