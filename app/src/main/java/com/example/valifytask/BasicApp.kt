package com.example.valifytask

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BasicApp : Application() {


    override fun onCreate() {
        super.onCreate()

    }


}