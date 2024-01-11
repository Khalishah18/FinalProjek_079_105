package com.example.finalprojek_079_105.repositori

import com.example.finalprojek_079_105.data.Pembeli
import com.example.finalprojek_079_105.data.PembeliDao
import kotlinx.coroutines.flow.Flow

class OfflineRepositoriPembeli(private val pembeliDao: PembeliDao) : RepositoriPembeli {
    override fun getAllPembelistream(): Flow<List<Pembeli>> = pembeliDao.getALLPembeli()

    override fun getPembelistream(id: Int): Flow<Pembeli?> {
        return pembeliDao.getPembeli(id)
    }

    override suspend fun insertPembeli(pembeli: Pembeli) = pembeliDao.insert(pembeli)

    override suspend fun deletePembeli(pembeli: Pembeli) = pembeliDao.delete(pembeli)

    override suspend fun updatePembeli(pembeli: Pembeli)
    {pembeliDao.update(pembeli)
    }

}