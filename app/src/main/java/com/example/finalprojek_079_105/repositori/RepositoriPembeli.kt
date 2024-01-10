package com.example.finalprojek_079_105.repositori

import com.example.finalprojek_079_105.data.Pembeli
import kotlinx.coroutines.flow.Flow

interface RepositoriPembeli {
    fun getAllPembelistream(): Flow<List<Pembeli>>

    fun getPembelistream(id: Int): Flow<Pembeli?>

    suspend fun insertPembeli(pembeli: Pembeli)

    suspend fun deletePembeli(pembeli: Pembeli)

    suspend fun updatePembeli(pembeli: Pembeli)
}