package com.example.finalprojek_079_105

import android.app.Application
import com.example.finalprojek_079_105.repositori.ContainerApp
import com.example.finalprojek_079_105.repositori.ContainerDataApp

class AplikasiPembeli : Application() {
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}