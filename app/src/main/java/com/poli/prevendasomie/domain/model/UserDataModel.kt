package com.poli.prevendasomie.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class UserDataModel(

    @PrimaryKey
    val id: Int? = 0,
    val email: String? = "",
    val username: String? = "",
    val password: String? = "", // isso não deveria estar aqui. mas ok por enquanto
    val appKey: String? = "",
    val appSecret: String? = "",
    val accessToken: String? = ""

)
