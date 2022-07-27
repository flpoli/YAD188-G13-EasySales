package com.poli.easysales.domain.mappers

import com.poli.easysales.data.local.entities.pedidos.CabecalhoEntity
import com.poli.easysales.data.local.entities.pedidos.DetEntity
import com.poli.easysales.data.local.entities.pedidos.ImpostoEntity
import com.poli.easysales.data.local.entities.pedidos.InfAdicEntity
import com.poli.easysales.data.local.entities.pedidos.ObservacaoEntity
import com.poli.easysales.data.local.entities.pedidos.PedidoVendaProdutoEntity
import com.poli.easysales.data.local.entities.pedidos.ProdutoEntity
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

fun PedidoVendaProduto.toPedidoEntity(): PedidoVendaProdutoEntity {

    return PedidoVendaProdutoEntity(
        id = 0,
        cabecalho = cabecalho.toCabecalhoEntity(),
        det = det?.map { it.toDetEntity() },
        frete = null,
        infoCadastro = null,
        totalPedido = null,
        informacoesAdicionais = null,
        listaParcelas = null,
        observacoes = null,
    )
}

fun PedidoVendaProdutoEntity.toPedidoModel(): PedidoVendaProduto {

    return PedidoVendaProduto()
}

fun Det.toDetEntity(): DetEntity {

    return DetEntity(
        produto = produto?.toProdutoEntity(),
        infAdic = infAdic?.toInfAdicEntity(),
        ide = ide,
        imposto = imposto?.toImpostoEntity(),
        observacao = observacao?.toObsEntity(),

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
fun Imposto.toImpostoEntity(): ImpostoEntity {

    return ImpostoEntity(
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

fun Observacao.toObsEntity(): ObservacaoEntity {

    return ObservacaoEntity(
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
fun InfAdic.toInfAdicEntity(): InfAdicEntity {

    return InfAdicEntity(
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
fun Produto.toProdutoEntity(): ProdutoEntity {

    return ProdutoEntity(
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

fun Cabecalho.toCabecalhoEntity(): CabecalhoEntity {

    return CabecalhoEntity(
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