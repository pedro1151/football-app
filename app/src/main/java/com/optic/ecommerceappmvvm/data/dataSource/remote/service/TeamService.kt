package com.optic.ecommerceappmvvm.data.dataSource.remote.service

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
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface TeamService {
/* Se utiliza Response de retrofit, en los archivos de servicios */
    @GET("football/teams")
    suspend fun getTeams(
    ): Response<List<Team>>

    @GET("football/teams/{team_id}")
    suspend fun getTeamById(
        @Path("team_id") teamId: Int
    ): Response<Team>


    @GET("football/getPlayers")
    suspend fun getPlayers(
    ): Response<List<Player>>

    /*  Recupera la informacion de un Player junto con todas sus estatisticas
    * ligas, equipos, goles etc..   */
    @GET("football/getPlayerStats")
    suspend fun getPlayerStats(
        @Query("player_id") playerId: Int
    ): Response<PlayerWithStats>

   // get ligas
   @GET("football/getLeagues")
   suspend fun getLeagues(
       @Query("name") name: String,
       @Query("type_") type: String,
       @Query("country_name") countryName: String
   ): Response<List<League>>



// SEGUIDORES
    @POST("football/createFollowedPlayer")
    suspend fun createFollowedPlayer(
    @Body request: FollowedPlayerRequest
    ): Response<FollowedPlayerResponse>

    @GET("football/getFollowedPlayers")
    suspend fun getFollowedPlayers(
    ): Response<List<Player>>

    @DELETE("football/deleteFollowed/{player_id}")
    suspend fun deleteFollowedPlayer(
        @Path("player_id") playerId: Int
    ): Response<DefaultResponse>


    // TEAMS SEGUIDOS

    @POST("football/createFollowedTeam")
    suspend fun createFollowedTeam(
        @Body request: FollowedTeamRequest
    ): Response<FollowedTeamResponse>

    @GET("football/getFollowedTeams")
    suspend fun getFollowedTeams(
    ): Response<List<Team>>

    @DELETE("football/deleteFollowedTeam/{team_id}")
    suspend fun deleteFollowedTeam(
        @Path("team_id") teamId: Int
    ): Response<DefaultResponse>

    // MATCHES ( FIXTURES ) POR TEAMS SEGUUIDOS

    @GET("football/getFixtureFollowedTeams")
    suspend fun getFixtureFollowedTeams(
        @Query("season") season: Int,
        @Query("date") date: String
    ): Response<List<FixtureResponse>>

    //Fixture de un equipo en general
    @GET("football/fixtures/team/{team_id}")
    suspend fun getFixtureTeam(
        @Path("team_id") teamId: Int
    ): Response<List<FixtureResponse>>


    // PARA SEGUIR LIGAS

    @POST("football/createFollowedLeague")
    suspend fun createFollowedLeague(
        @Body request: FollowedLeagueRequest
    ): Response<FollowedLeagueResponse>

    @GET("football/getFollowedLeagues")
    suspend fun getFollowedLeagues(
    ): Response<List<League>>

    @DELETE("football/deleteFollowedLeague/{league_id}")
    suspend fun deleteFollowedLeague(
        @Path("league_id") leagueId: Int
    ): Response<DefaultResponse>


}
