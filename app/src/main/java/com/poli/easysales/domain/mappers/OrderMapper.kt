package com.poli.easysales.domain.mappers

import com.poli.easysales.data.remote.dto.pedidos.CabecalhoDto
import com.poli.easysales.data.remote.dto.pedidos.DetDto
import com.poli.easysales.data.remote.dto.pedidos.ImpostoDto
import com.poli.easysales.data.remote.dto.pedidos.InfAdicDto
import com.poli.easysales.data.remote.dto.pedidos.ObservacaoDto
import com.poli.easysales.data.remote.dto.pedidos.PedidoVendaProdutoDto
import com.poli.easysales.data.remote.dto.pedidos.ProdutoDto
import com.poli.easysales.domain.model.pedidos.Cabecalho
import com.poli.easysales.domain.model.pedidos.Det
import com.poli.easysales.domain.model.pedidos.Imposto
import com.poli.easysales.domain.model.pedidos.InfAdic
import com.poli.easysales.domain.model.pedidos.Observacao
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import com.poli.easysales.domain.model.pedidos.Produto

fun PedidoVendaProduto.toPedidoDto(): PedidoVendaProdutoDto {

    return PedidoVendaProdutoDto(
        id = 0,
        cabecalho = cabecalho.toCabecalhoDto(),
        det = det?.map { it.toDetDto() },
        departamentos = null,
        exportacao = null,
        frete = null,
        infoCadastro = null,
        totalPedido = null,
        informacoesAdicionais = null,
        listaParcelas = null,
        observacoes = null,
    )

}


fun Det.toDetDto(): DetDto {

    return DetDto(

        produto = produto?.toProdutoDto(),
        infAdic = infAdic?.toInfAdicDto(),
        combustivel = null,
        ide = ide,
        imposto = imposto?.toImpostoDto(),
        observacao = observacao?.toObsDto(),
        rastreabilidade = null
    )

}

fun Imposto.toImpostoDto(): ImpostoDto {

    return ImpostoDto(
        cofinsPadrao = cofinsPadrao,
        cofinsSt = cofinsSt,
        csll = csll,
        icms = icms,
        icmsIe = icmsIe,
        icmsSn = icmsSn,
        icmsSt = icmsSt,
        inss = inss,
        ipi = ipi,
        irrf = irrf,
        iss = iss,
        pisPadrao = pisPadrao,
        pisSt = pisSt
    )

}

fun Observacao.toObsDto(): ObservacaoDto {

    return ObservacaoDto(
        obsItem = obsItem

    )
}

fun InfAdic.toInfAdicDto(): InfAdicDto {

    return InfAdicDto(
        codigoCategoriaItem = codigoCategoriaItem,
        naoMovimentarEstoque = naoMovimentarEstoque,
        naoGerarFinanceiro = naoGerarFinanceiro,
        dadosAdicionaisItem = dadosAdicionaisItem,
        codigoCenarioImpostosItem = codigoCenarioImpostosItem,
        pesoBruto = pesoBruto,
        pesoLiquido = pesoLiquido,
        codigoLocalEstoque = codigoLocalEstoque,
        itemPedidoCompra = itemPedidoCompra,
        numeroPedidoCompra = numeroPedidoCompra,
    )
}

fun Produto.toProdutoDto(): ProdutoDto {

    return ProdutoDto(
        cfop = cfop,
        cnpjFabricante = cnpjFabricante,
        codigo = codigo,
        codigoProduto = codigoProduto,
        codigoTabelaPreco = codigoTabelaPreco,
        descricao = descricao,
        ean = ean,
        indicadorEscala = indicadorEscala,
        motivoIcmsDesonerado = motivoIcmsDesonerado,
        ncm = ncm,
        percentualDesconto = percentualDesconto,
        quantidade = quantidade,
        reservado = reservado,
        tipoDesconto = tipoDesconto,
        unidade = unidade,
        valorDeducao = valorDeducao,
        valorDesconto = valorDesconto,
        valorIcmsDesonerado = valorIcmsDesonerado,
        valorMercadoria = valorMercadoria,
        valorTotal = valorTotal,
        valorUnitario = valorUnitario
    )
}

fun Cabecalho.toCabecalhoDto(): CabecalhoDto {

    return CabecalhoDto(
        bloqueado = bloqueado,
        codigoCenarioImpostos = codigoCenarioImpostos,
        codigoCliente = codigoCliente,
        codigoEmpresa = codigoEmpresa,
        codigoParcela = codigoParcela,
        codigoPedido = codigoPedido,
        codigoPedidoIntegracao = codigoPedidoIntegracao,
        dataPrevisao = dataPrevisao,
        etapa = etapa,
        importadoApi = importadoApi,
        numeroPedido = numeroPedido,
        origemPedido = origemPedido,
        qtdeParcelas = qtdeParcelas,
        quantidadeItens = quantidadeItens
    )
}