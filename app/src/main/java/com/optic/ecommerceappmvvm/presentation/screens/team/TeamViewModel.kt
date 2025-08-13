package com.optic.ecommerceappmvvm.presentation.screens.team

import androidx.lifecycle.ViewModel
import com.optic.ecommerceappmvvm.domain.useCase.team.TeamUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.optic.ecommerceappmvvm.domain.model.Team
import com.optic.ecommerceappmvvm.domain.model.fixture.FixtureResponse
import com.optic.ecommerceappmvvm.domain.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val teamUseCase: TeamUseCase
) : ViewModel() {

    private val _teamState =  MutableStateFlow<Resource<Team>>(Resource.Loading)
    val teamState: StateFlow<Resource<Team>> = _teamState

    private val _fixtureTeamsState = MutableStateFlow<Resource<List<FixtureResponse>>>(Resource.Loading)
    val fixtureTeamsState : StateFlow<Resource<List<FixtureResponse>>> = _fixtureTeamsState

    private val _nextFixtureTeamsState = MutableStateFlow<Resource<FixtureResponse>>(Resource.Loading)
    val nextFixtureTeamsState : StateFlow<Resource<FixtureResponse>> = _nextFixtureTeamsState

    private val _topFiveFixtureTeamsState = MutableStateFlow<Resource<List<FixtureResponse>>>(Resource.Loading)
    val topFiveFixtureTeamsState : StateFlow<Resource<List<FixtureResponse>>> = _topFiveFixtureTeamsState




    fun getTeamById(teamId: Int) {
        viewModelScope.launch {
            teamUseCase.getTeamByIdUC(teamId).collectLatest { result ->
                _teamState.value = result
            }
        }
    }


    fun getFixtureTeam(teamId: Int) {
        viewModelScope.launch {
            teamUseCase.getFixtureTeamUC(teamId).collectLatest { result ->
                _fixtureTeamsState.value = result
            }
        }
    }

    fun getNextFixtureTeam(teamId: Int) {
        viewModelScope.launch {
            teamUseCase.getNextFixtureTeamUC(teamId).collectLatest { result ->
                _nextFixtureTeamsState.value = result
            }
        }
    }

    fun getTopFiveFixtureTeam(teamId: Int) {
        viewModelScope.launch {
            teamUseCase.getTopFiveFixtureTeamUC(teamId).collectLatest { result ->
                _topFiveFixtureTeamsState.value = result
            }
        }
    }
}