package com.poli.easysales.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.poli.easysales.common.Constants.USER_TABLE

@Entity(tableName = USER_TABLE)
data class UserDataModel(

    @PrimaryKey
    val id: Int? = 0,
    val email: String? = "",
    var username: String? = "",
    val appKey: String? = "",
    val appSecret: String? = "",
    val accessToken: String? = ""

)
