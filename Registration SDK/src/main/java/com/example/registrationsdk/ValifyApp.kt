package com.example.registrationsdk

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


class ValifyApp : Application() {


    override fun onCreate() {
        super.onCreate()

//        if (BuildConfig.DEBUG) {
//            Timber.plant(Timber.DebugTree())
//        }
    }


}