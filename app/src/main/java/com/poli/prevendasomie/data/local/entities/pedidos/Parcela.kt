package com.poli.prevendasomie.data.local.entities.pedidos

import androidx.room.Embedded

data class Parcela(
    @Embedded("categoria_adiantamento")
    val categoriaAdiantamento: String?,
    @Embedded("conta_corrente_adiantamento")
    val contaCorrenteAdiantamento: Int?,
    @Embedded("data_vencimento")
    val dataVencimento: String?,
    @Embedded("meio_pagamento")
    val meioPagamento: String?,
    @Embedded("nao_gerar_boleto")
    val naoGerarBoleto: String?,
    @Embedded("numero_parcela")
    val numeroParcela: Int?,
    @Embedded("parcela_adiantamento")
    val parcelaAdiantamento: String?,
    @Embedded("percentual")
    val percentual: Double?,
    @Embedded("quantidade_dias")
    val quantidadeDias: Int?,
    @Embedded("tipo_documento")
    val tipoDocumento: String?,
    @Embedded("valor")
    val valor: Double?
)
