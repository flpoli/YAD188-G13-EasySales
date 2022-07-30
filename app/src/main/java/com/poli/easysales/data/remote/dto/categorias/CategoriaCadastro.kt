package com.poli.easysales.data.remote.dto.categorias


import com.google.gson.annotations.SerializedName

data class CategoriaCadastro(
    @SerializedName("categoria_superior")
    val categoriaSuperior: String?,
    @SerializedName("codigo")
    val codigo: String?,
    @SerializedName("codigo_dre")
    val codigoDre: String?,
    @SerializedName("conta_despesa")
    val contaDespesa: String?,
    @SerializedName("conta_inativa")
    val contaInativa: String?,
    @SerializedName("conta_receita")
    val contaReceita: String?,
    @SerializedName("dadosDRE")
    val dadosDRE: DadosDRE?,
    @SerializedName("definida_pelo_usuario")
    val definidaPeloUsuario: String?,
    @SerializedName("descricao")
    val descricao: String?,
    @SerializedName("descricao_padrao")
    val descricaoPadrao: String?,
    @SerializedName("id_conta_contabil")
    val idContaContabil: String?,
    @SerializedName("nao_exibir")
    val naoExibir: String?,
    @SerializedName("natureza")
    val natureza: String?,
    @SerializedName("tag_conta_contabil")
    val tagContaContabil: String?,
    @SerializedName("totalizadora")
    val totalizadora: String?,
    @SerializedName("transferencia")
    val transferencia: String?
)