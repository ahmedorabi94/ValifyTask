package com.example.valifytask.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserInfo(
    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0,
    val userName: String,
    val email: String,
    val phoneNumber: String,
    val image: ByteArray? = null,
)
