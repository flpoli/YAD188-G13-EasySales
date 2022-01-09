package com.poli.prevendasomie.data.remote

data class Request(
    val call: String,
    val app_key: String,
    val app_secret: String,
    val param: List<Param>
)
