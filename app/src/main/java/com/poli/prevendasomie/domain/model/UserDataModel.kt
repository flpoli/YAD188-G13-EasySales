package com.poli.prevendasomie.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserDataModel(

    @PrimaryKey
    val id: Int? = 0,
    val email: String? = "",
    var username: String? = "",
    val appKey: String? = "",
    val appSecret: String? = "",
    val accessToken: String? = ""

)
