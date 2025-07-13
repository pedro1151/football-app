package com.optic.ecommerceappmvvm.presentation.screens.leagues

import androidx.lifecycle.ViewModel
import com.optic.ecommerceappmvvm.domain.useCase.team.TeamUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import com.optic.ecommerceappmvvm.domain.model.League.League
import com.optic.ecommerceappmvvm.domain.model.Team
import com.optic.ecommerceappmvvm.domain.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class LeagueViewModel @Inject constructor(
    private val teamUseCase: TeamUseCase
) : ViewModel() {

    private val _leaguesState = MutableStateFlow<Resource<List<League>>>(Resource.Loading)
    val leaguesState: StateFlow<Resource<List<League>>> = _leaguesState


    fun getLeagues(name: String = "", type: String = "", countryName: String = "") {
        viewModelScope.launch {
            teamUseCase.getLeaguesUseCase(name, type, countryName).collectLatest { result ->
                _leaguesState.value = result
            }
        }
    }
}