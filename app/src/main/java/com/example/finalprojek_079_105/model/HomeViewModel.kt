package com.example.finalprojek_079_105.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojek_079_105.data.Pembeli
import com.example.finalprojek_079_105.repositori.RepositoriPembeli
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel (private val repositoriPembeli: RepositoriPembeli): ViewModel(){
    companion object{
        private const val  TIMEOUT_MILLIS = 5_000L
    }

    val homeUiState: StateFlow<HomeUiState> = repositoriPembeli.getAllPembelistream().filterNotNull()
        .map { HomeUiState(listPembeli = it.toList()) }
        .stateIn(scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUiState())

    data class HomeUiState(
        val listPembeli: List<Pembeli> = listOf()

    )


}