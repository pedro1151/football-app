package com.optic.ecommerceappmvvm.presentation.screens.follow


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.optic.ecommerceappmvvm.domain.model.Team
import com.optic.ecommerceappmvvm.domain.model.followed.FollowedPlayerResponse
import com.optic.ecommerceappmvvm.domain.model.player.Player
import com.optic.ecommerceappmvvm.domain.model.response.DefaultResponse
import com.optic.ecommerceappmvvm.domain.useCase.team.TeamUseCase
import com.optic.ecommerceappmvvm.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FollowViewModel @Inject constructor(
    private val teamUseCase: TeamUseCase
) : ViewModel() {

    private val _teamsState = MutableStateFlow<Resource<List<Team>>>(Resource.Loading)
    val teamsState: StateFlow<Resource<List<Team>>> = _teamsState

    private val _playersState = MutableStateFlow<Resource<List<Player>>>(Resource.Loading)
    val playersState: StateFlow<Resource<List<Player>>> = _playersState



    // VAl para Jugadores seguidos y crear relacion jugador seguido - User

    private val _followedPlayerState = MutableStateFlow<Resource<FollowedPlayerResponse>>(Resource.Loading)
    val followedPlayerState: StateFlow<Resource<FollowedPlayerResponse>> = _followedPlayerState

    private val _followedPlayerListState = MutableStateFlow<Resource<List<Player>>>(Resource.Loading)
    val followedPlayerListState: StateFlow<Resource<List<Player>>> = _followedPlayerListState

    private val _deleteFollowedState = MutableStateFlow<Resource<DefaultResponse>>(Resource.Loading)
    val deleteFollowedState : StateFlow<Resource< DefaultResponse>> = _deleteFollowedState

    init {
        getTeams()
        getPlayers()
        getFollowedPlayers()
    }
    private fun getPlayers() {
        viewModelScope.launch {
            teamUseCase.getPlayersUseCase().collectLatest { result ->
                _playersState.value = result
            }
        }
    }
    private fun getTeams() {
        viewModelScope.launch {
            teamUseCase.getallTeamUseCase().collectLatest { result ->
                _teamsState.value = result
            }
        }
    }

    private fun getFollowedPlayers() {
        viewModelScope.launch {
            teamUseCase.getFollowedPlayersUC().collectLatest { result ->
                _followedPlayerListState.value = result
            }
        }
    }

    // borrar un seguido

    fun deleteFollowedPlayer(playerId: Int) {
        viewModelScope.launch {
            teamUseCase.deleteFollowedPlayerUC(playerId).collectLatest { result ->
                Log.d("FollowVM", "deleteFollowedPlayer result: $result")
                _deleteFollowedState.value = result

                if (result is Resource.Success) {
                    Log.d("FollowVM", "Refresh followed and all players")
                    getFollowedPlayers() // 👈 refresca la lista de jugadores seguidos
                    getPlayers()

                    // Forzar emitir valores nuevos aunque sean iguales (para test)
                    _playersState.value = _playersState.value
                    _followedPlayerListState.value = _followedPlayerListState.value
                }
            }


        }
    }



    // funciones para Jugadores seguidos y crear relacion jugador seguido - User

    fun createFollowedPlayer(playerId: Int) {
        viewModelScope.launch {
            teamUseCase.createFollowedPlayerUC(playerId).collectLatest { result ->
                Log.d("FollowVM", "createFollowedPlayer result: $result")
                _followedPlayerState.value = result

                if (result is Resource.Success) {
                    Log.d("FollowVM", "Refresh followed and all players")
                    getFollowedPlayers() // 👈 refresca la lista de jugadores seguidos
                    getPlayers()

                    // Forzar emitir valores nuevos aunque sean iguales (para test)
                    _playersState.value = _playersState.value
                    _followedPlayerListState.value = _followedPlayerListState.value
                }
            }


        }
    }

    // Lista Filtrada, jugadores que aun no ha sido seguidos

    val filteredPlayersState: StateFlow<List<Player>> = combine(
        playersState,
        followedPlayerListState
    ) { allPlayersResource, followedPlayersResource ->
        val allPlayers = (allPlayersResource as? Resource.Success)?.data?.toList() ?: emptyList()
        val followedPlayers = (followedPlayersResource as? Resource.Success)?.data?.toList() ?: emptyList()

        val followedIds = followedPlayers.mapNotNull { it.id }.toSet()
        val filtered = allPlayers.filter { it.id !in followedIds }

        println("combine ejecutado: jugadores=${allPlayers.size}, seguidos=${followedPlayers.size}, filtrados=${filtered.size}")
        filtered
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )


}