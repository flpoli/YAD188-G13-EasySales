package com.poli.prevendasomie.presentation.clientes.cliente_form

import java.time.LocalDateTime

fun genCodCli(): String {

    return "C${LocalDateTime.now()}"
        .replace("-", "")
        .replace(".", "")
        .replace(":", "")
}
