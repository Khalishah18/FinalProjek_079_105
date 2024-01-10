package com.example.finalprojek_079_105.repositori

import android.content.Context
import com.example.finalprojek_079_105.data.DatabasePembeli

interface ContainerApp {
    val repositoriPembeli : RepositoriPembeli
}

class ContainerDataApp(private val context: Context): ContainerApp{
    override val repositoriPembeli : RepositoriPembeli by lazy {
        OfflineRepositoriPembeli(DatabasePembeli.getDatabase(context).pembeliDao())
    }

}