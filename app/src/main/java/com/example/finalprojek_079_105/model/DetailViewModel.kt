package com.example.finalprojek_079_105.model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojek_079_105.repositori.RepositoriPembeli
import com.example.finalprojek_079_105.ui.halaman.DetailsDestination
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoriPembeli: RepositoriPembeli
): ViewModel(){
    private  val pembeliId : Int = checkNotNull(savedStateHandle[DetailsDestination.pembeliIdArg])
    val uiState: StateFlow<ItemDetailsUiState> =
        repositoriPembeli.getAllPembelistream(pembeliId)
            .filterNotNull()
            .map {
                ItemDetailsUiState(detailPembeli = it.toDetailPembeli())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = ItemDetailsUiState()
            )

    suspend fun deleteItem(){
        repositoriPembeli.deletePembeli(uiState.value.detailPembeli.toPembeli())
    }

    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class ItemDetailsUiState(
    val outOfStock: Boolean = true,
    val  detailPembeli: DetailPembeli= DetailPembeli(),
)