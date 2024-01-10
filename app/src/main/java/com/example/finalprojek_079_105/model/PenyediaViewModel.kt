package com.example.finalprojek_079_105.model

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.finalprojek_079_105.AplikasiPembeli

object PenyediaViewModel{
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiPembeli().container.repositoriPembeli)
        }

        initializer {
            EntryViewModel(aplikasiPembeli().container.repositoriPembeli)
        }

        initializer {
            DetailViewModel(createSavedStateHandle(),
                aplikasiPembeli().container.repositoriPembeli)
        }

        initializer {
            EditViewModel(createSavedStateHandle(),
                aplikasiPembeli().container.repositoriPembeli)
        }



    }

}


fun CreationExtras.aplikasiPembeli():AplikasiPembeli =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiPembeli)