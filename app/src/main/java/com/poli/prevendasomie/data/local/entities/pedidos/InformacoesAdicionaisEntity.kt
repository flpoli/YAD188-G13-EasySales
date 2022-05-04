package com.poli.prevendasomie.data.local.entities.pedidos

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import retrofit2.http.FormUrlEncoded

@Entity(tableName = "informacoes_adicionais")
data class InformacoesAdicionaisEntity(

    @PrimaryKey(autoGenerate = true)
    val infoId: Int,
    val orderId: Int,

    @SerializedName("codProj")
    val codProj: Long?,
    @SerializedName("codVend")
    val codVend: Long?,
    @SerializedName("codigo_categoria")
    val codigoCategoria: String?,
    @SerializedName("codigo_conta_corrente")
    val codigoContaCorrente: Long?,
    @SerializedName("consumidor_final")
    val consumidorFinal: String?,
    @SerializedName("contato")
    val contato: String?,
    @SerializedName("dados_adicionais_nf")
    val dadosAdicionaisNf: String?,
    @SerializedName("enviar_email")
    val enviarEmail: String?,
    @SerializedName("numero_contrato")
    val numeroContrato: String?,
    @SerializedName("numero_pedido_cliente")
    val numeroPedidoCliente: String?,
    // @SerializedName("outros_detalhes")
    // val outrosDetalhes: OutrosDetalhes?,
    @SerializedName("utilizar_emails")
    val utilizarEmails: String?
)
