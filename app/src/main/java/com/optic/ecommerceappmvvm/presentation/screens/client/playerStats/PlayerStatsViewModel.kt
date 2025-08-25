package com.optic.ecommerceappmvvm.presentation.screens.client.playerStats

import android.util.Log
import androidx.lifecycle.ViewModel
import com.optic.ecommerceappmvvm.domain.useCase.team.TeamUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.optic.ecommerceappmvvm.domain.model.player.Player
import com.optic.ecommerceappmvvm.domain.model.player.playerteams.PlayerTeamsResponse
import com.optic.ecommerceappmvvm.domain.model.player.stats.PlayerWithStats
import com.optic.ecommerceappmvvm.domain.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class PlayerStatsViewModel @Inject constructor(
    private val teamUseCase: TeamUseCase
) : ViewModel() {

    private val _playerStatsState =  MutableStateFlow<Resource<PlayerWithStats>>(Resource.Loading)
    val playerStatsState: StateFlow<Resource<PlayerWithStats>> = _playerStatsState

    private val _playerTeamsState =  MutableStateFlow<Resource<PlayerTeamsResponse>>(Resource.Loading)
    val playerTeamsState: StateFlow<Resource<PlayerTeamsResponse>> = _playerTeamsState





    fun getPlayerStats(playerId: Int) {
        viewModelScope.launch {
            teamUseCase.getPlayerStatsUseCase(playerId).collectLatest { result ->
                _playerStatsState.value = result
            }
        }
    }

    fun getPlayerTeams(playerId: Int) {
        viewModelScope.launch {
            try {
                teamUseCase.getPlayerTeamsUC(playerId).collectLatest { result ->
                    Log.d("PlayerScreen", "Result received: $result")
                    _playerTeamsState.value = result
                }
            } catch (e: Exception) {
                Log.e("PlayerScreen", "Error fetching standings", e)
                _playerTeamsState.value = Resource.Failure(e.message ?: "Unknown error")
            }
        }
    }
}