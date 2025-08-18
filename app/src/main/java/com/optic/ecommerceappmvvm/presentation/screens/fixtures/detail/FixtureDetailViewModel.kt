package com.optic.ecommerceappmvvm.presentation.screens.fixtures.detail


import androidx.lifecycle.ViewModel
import com.optic.ecommerceappmvvm.domain.useCase.team.TeamUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.optic.ecommerceappmvvm.domain.model.Team
import com.optic.ecommerceappmvvm.domain.model.fixture.FixtureResponse
import com.optic.ecommerceappmvvm.domain.model.standing.StandingResponse
import com.optic.ecommerceappmvvm.domain.model.team.TeamResponse
import com.optic.ecommerceappmvvm.domain.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import android.util.Log


@HiltViewModel
class FixtureDetailViewModel @Inject constructor(
    private val teamUseCase: TeamUseCase
) : ViewModel() {

    private val _fixtureState = MutableStateFlow<Resource<FixtureResponse>>(Resource.Loading)
    val fixtureState: StateFlow<Resource<FixtureResponse>> = _fixtureState

    //standings
    private val _standingState = MutableStateFlow<Resource<List<StandingResponse>>>(Resource.Loading)
    val standingState: StateFlow<Resource<List<StandingResponse>>> = _standingState



    fun getFixtureById(id: Int) {
        viewModelScope.launch {
            teamUseCase.getFixtureByIdUC(id).collectLatest { result ->
                _fixtureState.value = result
            }
        }
    }


    fun getLeagueStandings(leagueId: Int, season: Int) {
        Log.d("StandingViewModel", "getLeagueStandings called with leagueId=$leagueId, season=$season")

        viewModelScope.launch {
            try {
                teamUseCase.getLeagueStandingsUC(leagueId, season).collectLatest { result ->
                    Log.d("StandingViewModel", "Result received: $result")
                    _standingState.value = result
                }
            } catch (e: Exception) {
                Log.e("StandingViewModel", "Error fetching standings", e)
                _standingState.value = Resource.Failure(e.message ?: "Unknown error")
            }
        }
    }

}