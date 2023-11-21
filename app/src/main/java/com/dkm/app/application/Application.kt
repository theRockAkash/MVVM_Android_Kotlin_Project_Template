package com.dkm.app.application


import com.dkm.app.BuildConfig
import com.therockakash.shaketrace.ShakeTrace
import dagger.hilt.android.HiltAndroidApp

/**
 * @Created by akash on 11/21/2023.
 * Know more about author on <a href="https://akash.cloudemy.in">...</a>
 */
@HiltAndroidApp
class Application : android.app.Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG)
        {
            ShakeTrace.init(this)
        }

    }
}