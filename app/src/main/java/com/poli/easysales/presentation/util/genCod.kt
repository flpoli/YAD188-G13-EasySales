package com.poli.easysales.presentation.util

import java.time.LocalDateTime
import java.time.LocalTime
import java.time.temporal.ChronoField
import kotlin.random.Random

fun genCodCli(): String {

    return "C${LocalDateTime.now()}"
        .replace("-", "")
        .replace(".", "")
        .replace(":", "")
}

fun genCodOrder(): OrderCodes {

    val codigoPedidoIntegracao = "P${LocalDateTime.now()}"
        .replace("-", "")
        .replace(".", "")
        .replace(":", "")

    val seed = LocalTime.now().getLong(ChronoField.SECOND_OF_MINUTE)
    val codigoPedido = Random(seed).nextLong().countTrailingZeroBits().toLong()

    return OrderCodes(codigoPedido, codigoPedidoIntegracao)
}

data class OrderCodes(

    val codigoPedido: Long,
    val codigoPedidoIntegracao: String,

)
