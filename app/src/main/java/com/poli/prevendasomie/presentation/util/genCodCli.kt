package com.poli.prevendasomie.presentation.util

import java.time.LocalDateTime

fun genCodCli(): String {

    return "C${LocalDateTime.now()}"
        .replace("-", "")
        .replace(".", "")
        .replace(":", "")
}
