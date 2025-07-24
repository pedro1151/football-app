package com.optic.ecommerceappmvvm.domain.repository

import com.optic.ecommerceappmvvm.domain.model.League.League
import com.optic.ecommerceappmvvm.domain.model.player.Player
import com.optic.ecommerceappmvvm.domain.model.Team
import com.optic.ecommerceappmvvm.domain.model.fixture.FixtureResponse
import com.optic.ecommerceappmvvm.domain.model.followed.FollowedPlayerResponse
import com.optic.ecommerceappmvvm.domain.model.followed.FollowedTeamResponse
import com.optic.ecommerceappmvvm.domain.model.player.stats.PlayerWithStats
import com.optic.ecommerceappmvvm.domain.model.response.DefaultResponse
import com.optic.ecommerceappmvvm.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface TeamRepository {

    suspend fun getAll(): Flow<Resource<List<Team>>>
    suspend fun getPlayers(): Flow<Resource<List<Player>>>
    suspend fun getPlayerStats(playerId: Int): Flow<Resource<PlayerWithStats>>
    suspend fun getLeagues(name: String, type: String, countryName: String): Flow<Resource<List<League>>>

    //PLAYERS SEGUIDOS
    suspend fun getFollowedPlayers(): Flow<Resource<List<Player>>>
    suspend fun createFollowedPlayer(playerId: Int):Flow<Resource<FollowedPlayerResponse>>
    suspend fun deleteFollowedPlayer(playerId: Int):Flow<Resource<DefaultResponse>>


    //TEAMS SEGUIDOS
    suspend fun getFollowedTeams(): Flow<Resource<List<Team>>>
    suspend fun createFollowedTeam(teamId: Int):Flow<Resource<FollowedTeamResponse>>
    suspend fun deleteFollowedTeam(teamId: Int):Flow<Resource<DefaultResponse>>


    //MATCHES ( FIXTURE )
    suspend fun getFixtureFollowedTeams(season: Int, date: String): Flow<Resource<List<FixtureResponse>>>
}