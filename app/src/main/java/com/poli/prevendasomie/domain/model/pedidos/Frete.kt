package com.poli.prevendasomie.domain.model.pedidos

import com.google.gson.annotations.SerializedName

data class Frete(
    @SerializedName("codigo_rastreio")
    val codigoRastreio: String? = "",
    @SerializedName("codigo_tipo_entrega")
    val codigoTipoEntrega: Int? = 0,
    @SerializedName("codigo_transportadora")
    val codigoTransportadora: Long? = 0,
    @SerializedName("especie_volumes")
    val especieVolumes: String? = "",
    @SerializedName("marca_volumes")
    val marcaVolumes: String? = "",
    @SerializedName("modalidade")
    val modalidade: String? = "",
    @SerializedName("numeracao_volumes")
    val numeracaoVolumes: String? = "",
    @SerializedName("numero_lacre")
    val numeroLacre: String? = "",
    @SerializedName("outras_despesas")
    val outrasDespesas: Double? = 0.0,
    @SerializedName("peso_bruto")
    val pesoBruto: Double? = 0.0,
    @SerializedName("peso_liquido")
    val pesoLiquido: Double? = 0.0,
    @SerializedName("placa")
    val placa: String? = "",
    @SerializedName("placa_estado")
    val placaEstado: String? = "",
    @SerializedName("previsao_entrega")
    val previsaoEntrega: String? = "",
    @SerializedName("quantidade_volumes")
    val quantidadeVolumes: Int? = 0,
    @SerializedName("registro_transportador")
    val registroTransportador: String? = "",
    @SerializedName("valor_frete")
    val valorFrete: Double? = 0.0,
    @SerializedName("valor_seguro")
    val valorSeguro: Double? = 0.0,
    @SerializedName("veiculo_proprio")
    val veiculoProprio: String? = ""
)
