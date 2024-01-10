package com.example.finalprojek_079_105.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.finalprojek_079_105.data.Pembeli
import com.example.finalprojek_079_105.repositori.RepositoriPembeli

class  EntryViewModel(private val repositoriPembeli: RepositoriPembeli): ViewModel(){
    var uiStatePembeli by mutableStateOf(UIStatePembeli())
        private set

    private fun validasiInput(uiState: DetailPembeli = uiStatePembeli.DetailPembeli) : Boolean{
        return with(uiState){
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    fun updateUiState(detailPembeli: DetailPembeli){
        uiStatePembeli =
            UIStatePembeli(DetailPembeli = detailPembeli, isEntryValid = validasiInput(detailPembeli))
    }

    suspend fun  savePembeli(){
        if (validasiInput()){
            repositoriPembeli.insertPembeli(uiStatePembeli.DetailPembeli.toPembeli())
        }
    }
}

data class UIStatePembeli(
    val DetailPembeli: DetailPembeli=DetailPembeli(),
    val isEntryValid: Boolean = false

)

data class DetailPembeli(
    val id: Int = 0,
    val nama: String = "",
    val alamat: String = "",
    val telpon: String = "",
    val email: String = "",
    val payment: String = "",
    )

fun DetailPembeli.toPembeli(): Pembeli = Pembeli(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon,
    email = email,
    payment = payment
)

fun Pembeli.toDetailPembeli(): DetailPembeli = DetailPembeli(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon,
    email = email,
    payment = payment

)

fun Pembeli.toUiStatePembeli(isEntryValid: Boolean = false): UIStatePembeli = UIStatePembeli(
    DetailPembeli = this.toDetailPembeli(),
    isEntryValid = isEntryValid
)

