package com.example.finalprojek_079_105.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojek_079_105.repositori.RepositoriPembeli
import com.example.finalprojek_079_105.ui.halaman.ItemEditDestination
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoriPembeli: RepositoriPembeli
): ViewModel(){
    var pembeliUiState by mutableStateOf(UIStatePembeli())
        private set
    private val itemId: Int = checkNotNull(savedStateHandle[ItemEditDestination.itemIdArg])

    init {
        viewModelScope.launch {
            pembeliUiState = repositoriPembeli.getPembelistream(itemId).filterNotNull().first().toUiStatePembeli(true)
        }
    }

    suspend fun updatePembeli(){
        if (validasiInput(pembeliUiState.DetailPembeli)){
            repositoriPembeli.updatePembeli(pembeliUiState.DetailPembeli.toPembeli())
        }
        else{
            println("Data Tidak Valid")
        }
    }
    fun updateUiState(detailPembeli: DetailPembeli){
        pembeliUiState =
            UIStatePembeli(DetailPembeli = detailPembeli, isEntryValid = validasiInput(detailPembeli))
    }


    private fun validasiInput(uiState: DetailPembeli = pembeliUiState.DetailPembeli): Boolean{
        return with(uiState){
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }
}