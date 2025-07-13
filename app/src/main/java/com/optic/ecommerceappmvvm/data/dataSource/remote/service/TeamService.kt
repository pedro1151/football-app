package com.optic.ecommerceappmvvm.data.dataSource.remote.service

import com.optic.ecommerceappmvvm.domain.model.League.League
import com.optic.ecommerceappmvvm.domain.model.player.Player
import com.optic.ecommerceappmvvm.domain.model.Team
import com.optic.ecommerceappmvvm.domain.model.followed.FollowedPlayerRequest
import com.optic.ecommerceappmvvm.domain.model.followed.FollowedPlayerResponse
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

}
