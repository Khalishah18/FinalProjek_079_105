package com.example.finalprojek_079_105.model

import androidx.lifecycle.ViewModel
import com.example.finalprojek_079_105.repositori.RepositoriPembeli
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map

class HomeViewModel (private val repositoriPembeli: RepositoriPembeli): ViewModel(){
    companion object{
        private const val  TIMEOUT_MILLIS = 5_000L
    }


}