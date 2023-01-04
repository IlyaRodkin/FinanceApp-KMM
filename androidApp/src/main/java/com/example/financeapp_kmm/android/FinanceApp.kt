package com.example.financeapp_kmm.android

import PlatformConfiguration
import PlatformSDK
import android.app.Application

class FinanceApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initPlatformSDK()
    }

    private fun initPlatformSDK() {
        PlatformSDK.init(configuration = PlatformConfiguration(applicationContext))
    }
}