package com.poli.prevendasomie.data.remote.responses.produtos


import com.google.gson.annotations.SerializedName

data class ProdutoServicoCadastro(
    @SerializedName("aliquota_cofins")
    val aliquotaCofins: Int?,
    @SerializedName("aliquota_ibpt")
    val aliquotaIbpt: Int?,
    @SerializedName("aliquota_icms")
    val aliquotaIcms: Int?,
    @SerializedName("aliquota_pis")
    val aliquotaPis: Int?,
    @SerializedName("altura")
    val altura: Int?,
    @SerializedName("bloqueado")
    val bloqueado: String?,
    @SerializedName("bloquear_exclusao")
    val bloquearExclusao: String?,
    @SerializedName("cest")
    val cest: String?,
    @SerializedName("cfop")
    val cfop: String?,
    @SerializedName("codInt_familia")
    val codIntFamilia: String?,
    @SerializedName("codigo")
    val codigo: String?,
    @SerializedName("codigo_beneficio")
    val codigoBeneficio: String?,
    @SerializedName("codigo_familia")
    val codigoFamilia: Int?,
    @SerializedName("codigo_produto")
    val codigoProduto: Int?,
    @SerializedName("codigo_produto_integracao")
    val codigoProdutoIntegracao: String?,
    @SerializedName("csosn_icms")
    val csosnIcms: String?,
    @SerializedName("cst_cofins")
    val cstCofins: String?,
    @SerializedName("cst_icms")
    val cstIcms: String?,
    @SerializedName("cst_pis")
    val cstPis: String?,
    @SerializedName("dadosIbpt")
    val dadosIbpt: DadosIbpt?,
    @SerializedName("descr_detalhada")
    val descrDetalhada: String?,
    @SerializedName("descricao")
    val descricao: String?,
    @SerializedName("descricao_familia")
    val descricaoFamilia: String?,
    @SerializedName("dias_crossdocking")
    val diasCrossdocking: Int?,
    @SerializedName("dias_garantia")
    val diasGarantia: Int?,
    @SerializedName("ean")
    val ean: String?,
    @SerializedName("estoque_minimo")
    val estoqueMinimo: Int?,
    @SerializedName("exibir_descricao_nfe")
    val exibirDescricaoNfe: String?,
    @SerializedName("exibir_descricao_pedido")
    val exibirDescricaoPedido: String?,
    @SerializedName("importado_api")
    val importadoApi: String?,
    @SerializedName("inativo")
    val inativo: String?,
    @SerializedName("info")
    val info: Info?,
    @SerializedName("largura")
    val largura: Int?,
    @SerializedName("lead_time")
    val leadTime: Int?,
    @SerializedName("marca")
    val marca: String?,
    @SerializedName("modelo")
    val modelo: String?,
    @SerializedName("motivo_deson_icms")
    val motivoDesonIcms: String?,
    @SerializedName("ncm")
    val ncm: String?,
    @SerializedName("obs_internas")
    val obsInternas: String?,
    @SerializedName("per_icms_fcp")
    val perIcmsFcp: Int?,
    @SerializedName("peso_bruto")
    val pesoBruto: Int?,
    @SerializedName("peso_liq")
    val pesoLiq: Int?,
    @SerializedName("profundidade")
    val profundidade: Int?,
    @SerializedName("quantidade_estoque")
    val quantidadeEstoque: Int?,
    @SerializedName("recomendacoes_fiscais")
    val recomendacoesFiscais: RecomendacoesFiscais?,
    @SerializedName("red_base_icms")
    val redBaseIcms: Int?,
    @SerializedName("tipoItem")
    val tipoItem: String?,
    @SerializedName("unidade")
    val unidade: String?,
    @SerializedName("valor_unitario")
    val valorUnitario: Double?
)