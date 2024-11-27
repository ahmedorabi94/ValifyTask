package com.example.registrationsdk.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update

@Dao
interface UserInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(items: List<UserInfo>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserInfo(items: UserInfo)

    @Query("SELECT * FROM user")
    fun getAllItems(): List<UserInfo>

    @Query("DELETE FROM user")
    suspend fun deleteAllItems()

    @Query("SELECT * FROM user where userName=:username")
    fun getItemById(username : String): List<UserInfo>

    @Delete
    suspend fun deleteUser(userInfo: UserInfo)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUsername(userInfo: UserInfo): Int

    @Query("SELECT * FROM user ORDER BY userId DESC LIMIT 1")
    suspend fun getLastItem(): UserInfo

    @Transaction
    suspend fun insertOrUpdate(items: List<UserInfo>) {
        items.forEach {model ->
            val list = getItemById(model.userName ?: "")
            if (list.isEmpty()){
                insertUserInfo(model)
            }else{
                updateUsername(model)
            }

        }
    }

}