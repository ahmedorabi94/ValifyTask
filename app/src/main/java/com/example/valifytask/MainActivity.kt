package com.example.valifytask

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.registrationsdk.ui.presentation.RegisterActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this,RegisterActivity::class.java))
        finish()
    }
}
