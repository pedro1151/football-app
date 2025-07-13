package com.optic.ecommerceappmvvm.presentation.screens.client.playerStats

import androidx.lifecycle.ViewModel
import com.optic.ecommerceappmvvm.domain.useCase.team.TeamUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.optic.ecommerceappmvvm.domain.model.player.Player
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



    fun getPlayerStats(playerId: Int) {
        viewModelScope.launch {
            teamUseCase.getPlayerStatsUseCase(playerId).collectLatest { result ->
                _playerStatsState.value = result
            }
        }
    }
}