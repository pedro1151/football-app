package com.optic.ecommerceappmvvm.data.repository



import com.optic.ecommerceappmvvm.data.dataSource.remote.TeamRemoteDataSource
import com.optic.ecommerceappmvvm.domain.model.League.League
import com.optic.ecommerceappmvvm.domain.model.player.Player
import com.optic.ecommerceappmvvm.domain.model.Team
import com.optic.ecommerceappmvvm.domain.model.followed.FollowedPlayerResponse
import com.optic.ecommerceappmvvm.domain.model.player.stats.PlayerWithStats
import com.optic.ecommerceappmvvm.domain.model.response.DefaultResponse
import com.optic.ecommerceappmvvm.domain.repository.TeamRepository
import com.optic.ecommerceappmvvm.domain.util.Resource
import com.optic.ecommerceappmvvm.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TeamRepositoryImpl(
    private val teamRemoteDataSource: TeamRemoteDataSource
): TeamRepository{
    override suspend fun getAll(): Flow<Resource<List<Team>>> = flow{
        emit(
            ResponseToRequest.send(
                teamRemoteDataSource.getAll()
            )
        )
    }

    override suspend fun getPlayers(): Flow<Resource<List<Player>>> = flow{
        emit(
            ResponseToRequest.send(
                teamRemoteDataSource.getPlayers()
            )
        )
    }

    override suspend fun getPlayerStats(playerId: Int): Flow<Resource<PlayerWithStats>> = flow{
        emit(
            ResponseToRequest.send(
                teamRemoteDataSource.getPlayerStats(playerId)
            )
        )
    }

    override suspend fun getLeagues(
        name: String,
        type: String,
        countryName: String
    ): Flow<Resource<List<League>>>  = flow{
        emit(
            ResponseToRequest.send(
                teamRemoteDataSource.getLeagues(name, type, countryName)
            )
        )
    }

    override suspend fun getFollowedPlayers(): Flow<Resource<List<Player>>>  = flow{
        emit(
            ResponseToRequest.send(
                teamRemoteDataSource.getFollowedPlayers()
            )
        )
    }

    override suspend fun createFollowedPlayer(playerId: Int):  Flow<Resource<FollowedPlayerResponse>> = flow{
        emit(
            ResponseToRequest.send(
                teamRemoteDataSource.createFollowedPlayer(playerId)
            )
        )
    }

    override suspend fun deleteFollowedPlayer(playerId: Int): Flow<Resource<DefaultResponse>> = flow{
        emit(
            ResponseToRequest.send(
                teamRemoteDataSource.deleteFollowedPlayer(playerId)
            )
        )
    }

}