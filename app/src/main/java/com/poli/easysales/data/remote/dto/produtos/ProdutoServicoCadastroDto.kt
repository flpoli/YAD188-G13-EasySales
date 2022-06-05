package com.poli.easysales.data.remote.dto.produtos

import com.google.gson.annotations.SerializedName

data class ProdutoServicoCadastroDto(
    @SerializedName("aliquota_cofins")
    val aliquotaCofins: Int? = 0,
    @SerializedName("aliquota_ibpt")
    val aliquotaIbpt: Int? = 0,
    @SerializedName("aliquota_icms")
    val aliquotaIcms: Int? = 0,
    @SerializedName("aliquota_pis")
    val aliquotaPis: Int? = 0,
    @SerializedName("altura")
    val altura: Int? = 0,
    @SerializedName("bloqueado")
    val bloqueado: String? = "",
    @SerializedName("bloquear_exclusao")
    val bloquearExclusao: String? = "",
    @SerializedName("cest")
    val cest: String? = "",
    @SerializedName("cfop")
    val cfop: String? = "",
    @SerializedName("codInt_familia")
    val codIntFamilia: String? = "",
    @SerializedName("codigo")
    val codigo: String? = "",
    @SerializedName("codigo_beneficio")
    val codigoBeneficio: String? = "",
    @SerializedName("codigo_familia")
    val codigoFamilia: Long? = 0,
    @SerializedName("codigo_produto")
    val codigoProduto: Long,
    @SerializedName("codigo_produto_integracao")
    val codigoProdutoIntegracao: String? = "",
    @SerializedName("csosn_icms")
    val csosnIcms: String? = "",
    @SerializedName("cst_cofins")
    val cstCofins: String? = "",
    @SerializedName("cst_icms")
    val cstIcms: String? = "",
    @SerializedName("cst_pis")
    val cstPis: String? = "",
    @SerializedName("dadosIbpt")
    val dadosIbpt: DadosIbpt? = DadosIbpt(),
    @SerializedName("descr_detalhada")
    val descrDetalhada: String? = "",
    @SerializedName("descricao")
    val descricao: String? = "",
    @SerializedName("descricao_familia")
    val descricaoFamilia: String? = "",
    @SerializedName("dias_crossdocking")
    val diasCrossdocking: Int? = 0,
    @SerializedName("dias_garantia")
    val diasGarantia: Int? = 0,
    @SerializedName("ean")
    val ean: String? = "",
    @SerializedName("estoque_minimo")
    val estoqueMinimo: Int? = 0,
    @SerializedName("exibir_descricao_nfe")
    val exibirDescricaoNfe: String? = "",
    @SerializedName("exibir_descricao_pedido")
    val exibirDescricaoPedido: String? = "",
    @SerializedName("importado_api")
    val importadoApi: String? = "",
    @SerializedName("inativo")
    val inativo: String? = "",
    @SerializedName("info")
    val info: Info? = Info(),
    @SerializedName("largura")
    val largura: Int? = 0,
    @SerializedName("lead_time")
    val leadTime: Int? = 0,
    @SerializedName("marca")
    val marca: String? = "",
    @SerializedName("modelo")
    val modelo: String? = "",
    @SerializedName("motivo_deson_icms")
    val motivoDesonIcms: String? = "",
    @SerializedName("ncm")
    val ncm: String? = "",
    @SerializedName("obs_internas")
    val obsInternas: String? = "",
    @SerializedName("per_icms_fcp")
    val perIcmsFcp: Float? = 0f,
    @SerializedName("peso_bruto")
    val pesoBruto: Float? = 0f,
    @SerializedName("peso_liq")
    val pesoLiq: Float? = 0f,
    @SerializedName("profundidade")
    val profundidade: Int? = 0,
    @SerializedName("quantidade_estoque")
    val quantidadeEstoque: Int? = 0,
    @SerializedName("recomendacoes_fiscais")
    val recomendacoesFiscais: RecomendacoesFiscais? = RecomendacoesFiscais(),
    @SerializedName("red_base_icms")
    val redBaseIcms: Float? = 0f,
    @SerializedName("tipoItem")
    val tipoItem: String? = "",
    @SerializedName("unidade")
    val unidade: String? = "",
    @SerializedName("valor_unitario")
    val valorUnitario: Double? = 0.0,
    @SerializedName("imagens")
    var imagens: List<Imagens>? = listOf(Imagens("")),

)
