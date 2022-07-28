package com.poli.easysales.domain.mappers

import com.poli.easysales.data.local.entities.pedidos.CabecalhoEntity
import com.poli.easysales.data.local.entities.pedidos.DetEntity
import com.poli.easysales.data.local.entities.pedidos.FreteEntity
import com.poli.easysales.data.local.entities.pedidos.ImpostoEntity
import com.poli.easysales.data.local.entities.pedidos.InfAdicEntity
import com.poli.easysales.data.local.entities.pedidos.InfoCadastroEntity
import com.poli.easysales.data.local.entities.pedidos.InformacoesAdicionaisEntity
import com.poli.easysales.data.local.entities.pedidos.ListaParcelasEntity
import com.poli.easysales.data.local.entities.pedidos.ObservacaoEntity
import com.poli.easysales.data.local.entities.pedidos.ObservacoesEntity
import com.poli.easysales.data.local.entities.pedidos.ParcelaEntity
import com.poli.easysales.data.local.entities.pedidos.PedidoVendaProdutoEntity
import com.poli.easysales.data.local.entities.pedidos.ProdutoEntity
import com.poli.easysales.data.local.entities.pedidos.TotalPedidoEntity
import com.poli.easysales.data.remote.dto.pedidos.CabecalhoDto
import com.poli.easysales.data.remote.dto.pedidos.DetDto
import com.poli.easysales.data.remote.dto.pedidos.ImpostoDto
import com.poli.easysales.data.remote.dto.pedidos.InfAdicDto
import com.poli.easysales.data.remote.dto.pedidos.InformacoesAdicionaisDto
import com.poli.easysales.data.remote.dto.pedidos.ObservacaoDto
import com.poli.easysales.data.remote.dto.pedidos.PedidoVendaProdutoDto
import com.poli.easysales.data.remote.dto.pedidos.ProdutoDto
import com.poli.easysales.domain.model.pedidos.Cabecalho
import com.poli.easysales.domain.model.pedidos.Det
import com.poli.easysales.domain.model.pedidos.Frete
import com.poli.easysales.domain.model.pedidos.Imposto
import com.poli.easysales.domain.model.pedidos.InfAdic
import com.poli.easysales.domain.model.pedidos.InfoCadastro
import com.poli.easysales.domain.model.pedidos.InformacoesAdicionais
import com.poli.easysales.domain.model.pedidos.ListaParcelas
import com.poli.easysales.domain.model.pedidos.Observacao
import com.poli.easysales.domain.model.pedidos.Observacoes
import com.poli.easysales.domain.model.pedidos.Parcela
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import com.poli.easysales.domain.model.pedidos.Produto
import com.poli.easysales.domain.model.pedidos.TotalPedido

fun PedidoVendaProduto.toPedidoDto(): PedidoVendaProdutoDto {

    return PedidoVendaProdutoDto(

        cabecalho = cabecalho.toCabecalhoDto(),
        det = det?.map { it.toDetDto() },
        departamentos = null,
        exportacao = null,
        frete = null,
        infoCadastro = null,
        totalPedido = null,
        informacoesAdicionais = informacoesAdicionais?.toInformacoesAdicionaisDto(),
        listaParcelas = null,
        observacoes = null,
    )
}

fun PedidoVendaProduto.toPedidoEntity(): PedidoVendaProdutoEntity {

    return PedidoVendaProdutoEntity(

        cabecalho = cabecalho.toCabecalhoEntity(),
        det = det?.map { it.toDetEntity() },
        frete = frete?.toFreteEntity(),
        infoCadastro = infoCadastro?.toInfoCadastroEntity(),
        totalPedido = totalPedido?.toTotalPedidoEntity(),
        informacoesAdicionais = informacoesAdicionais?.toInformacoesAdicionaisEntity(),
        listaParcelas = listaParcelas?.toListaParcelasEntity(),
        observacoes = observacoes?.toObservacoesEntity(),
    )
}

fun PedidoVendaProdutoEntity.toPedidoModel(): PedidoVendaProduto {

    return PedidoVendaProduto(
        cabecalho = cabecalho.toCabecalho(),
        observacoes = observacoes?.toObservacoes(),
        listaParcelas = listaParcelas?.toListaParcelas(),
        totalPedido = totalPedido?.toTotalPedido(),
        det = det?.map { it.toDet() },
        informacoesAdicionais = informacoesAdicionais?.toInformacoesAdicionais(),
        frete = frete?.toFrete(),
        infoCadastro = infoCadastro?.toInfoCadastro()
    )
}

fun Observacoes.toObservacoesEntity(): ObservacoesEntity {

    return ObservacoesEntity(
        obsVenda = obsVenda
    )
}
fun ObservacoesEntity.toObservacoes(): Observacoes {

    return Observacoes(obsVenda = obsVenda)
}

fun InformacoesAdicionais.toInformacoesAdicionaisDto(): InformacoesAdicionaisDto {

    return InformacoesAdicionaisDto(
        codProj = codProj,
        codVend = codVend,
        codigoCategoria = codigoCategoria,
        codigoContaCorrente = codigoContaCorrente,
        consumidorFinal = consumidorFinal,
        contato = contato,
        dadosAdicionaisNf = dadosAdicionaisNf,
        enviarEmail = enviarEmail,
        numeroContrato = numeroContrato,
        numeroPedidoCliente = numeroPedidoCliente,
        utilizarEmails = utilizarEmails,
        outrosDetalhes = null
    )
}

fun InformacoesAdicionaisEntity.toInformacoesAdicionais(): InformacoesAdicionais {

    return InformacoesAdicionais(
        codProj = codProj,
        codVend = codVend,
        codigoCategoria = codigoCategoria,
        codigoContaCorrente = codigoContaCorrente,
        consumidorFinal = consumidorFinal,
        contato = contato,
        dadosAdicionaisNf = dadosAdicionaisNf,
        enviarEmail = enviarEmail,
        numeroContrato = numeroContrato,
        numeroPedidoCliente = numeroPedidoCliente,
        utilizarEmails = utilizarEmails
    )
}

fun InformacoesAdicionais.toInformacoesAdicionaisEntity(): InformacoesAdicionaisEntity {

    return InformacoesAdicionaisEntity(
        codProj = codProj,
        codVend = codVend,
        codigoCategoria = codigoCategoria,
        codigoContaCorrente = codigoContaCorrente,
        consumidorFinal = consumidorFinal,
        contato = contato,
        dadosAdicionaisNf = dadosAdicionaisNf,
        enviarEmail = enviarEmail,
        numeroContrato = numeroContrato,
        numeroPedidoCliente = numeroPedidoCliente,
        utilizarEmails = utilizarEmails
    )
}

fun TotalPedidoEntity.toTotalPedido(): TotalPedido {

    return TotalPedido(
        baseCalculoIcms = baseCalculoIcms,
        baseCalculoSt = baseCalculoSt,
        valorCofins = valorCofins,
        valorCsll = valorCsll,
        valorDeducoes = valorDeducoes,
        valorDescontos = valorDescontos,
        valorIPI = valorIPI,
        valorIcms = valorIcms,
        valorInss = valorInss,
        valorIr = valorIr,
        valorIss = valorIss,
        valorMercadorias = valorMercadorias,
        valorPis = valorPis,
        valorSt = valorSt,
        valorTotalPedido = valorTotalPedido
    )
}

fun TotalPedido.toTotalPedidoEntity(): TotalPedidoEntity {

    return TotalPedidoEntity(
        baseCalculoIcms = baseCalculoIcms,
        baseCalculoSt = baseCalculoSt,
        valorCofins = valorCofins,
        valorCsll = valorCsll,
        valorDeducoes = valorDeducoes,
        valorDescontos = valorDescontos,
        valorIPI = valorIPI,
        valorIcms = valorIcms,
        valorInss = valorInss,
        valorIr = valorIr,
        valorIss = valorIss,
        valorMercadorias = valorMercadorias,
        valorPis = valorPis,
        valorSt = valorSt,
        valorTotalPedido = valorTotalPedido
    )
}

fun FreteEntity.toFrete(): Frete {

    return Frete(
        pesoLiquido = pesoLiquido,
        pesoBruto = pesoBruto,
        codigoRastreio = codigoRastreio,
        codigoTipoEntrega = codigoTipoEntrega,
        codigoTransportadora = codigoTransportadora,
        especieVolumes = especieVolumes,
        marcaVolumes = marcaVolumes,
        modalidade = modalidade,
        numeracaoVolumes = numeracaoVolumes,
        numeroLacre = numeroLacre,
        outrasDespesas = outrasDespesas,
        placa = placa,
        placaEstado = placaEstado,
        previsaoEntrega = previsaoEntrega,
        quantidadeVolumes = quantidadeVolumes,
        valorFrete = valorFrete,
        registroTransportador = registroTransportador,
        valorSeguro = valorSeguro,
        veiculoProprio = veiculoProprio
    )
}

fun Frete.toFreteEntity(): FreteEntity {

    return FreteEntity(
        pesoLiquido = pesoLiquido,
        pesoBruto = pesoBruto,
        codigoRastreio = codigoRastreio,
        codigoTipoEntrega = codigoTipoEntrega,
        codigoTransportadora = codigoTransportadora,
        especieVolumes = especieVolumes,
        marcaVolumes = marcaVolumes,
        modalidade = modalidade,
        numeracaoVolumes = numeracaoVolumes,
        numeroLacre = numeroLacre,
        outrasDespesas = outrasDespesas,
        placa = placa,
        placaEstado = placaEstado,
        previsaoEntrega = previsaoEntrega,
        quantidadeVolumes = quantidadeVolumes,
        valorFrete = valorFrete,
        registroTransportador = registroTransportador,
        valorSeguro = valorSeguro,
        veiculoProprio = veiculoProprio

    )
}

fun InfoCadastroEntity.toInfoCadastro(): InfoCadastro {

    return InfoCadastro(
        autorizado = autorizado,
        cImpAPI = cImpAPI,
        cancelado = cancelado,
        dAlt = dAlt,
        dCan = dCan,
        dFat = dFat,
        dInc = dInc,
        denegado = denegado,
        devolvido = devolvido,
        devolvidoParcial = devolvidoParcial,
        faturado = faturado,
        hAlt = hAlt,
        hCan = hCan,
        hFat = hFat,
        hInc = hInc,
        uAlt = uAlt,
        uCan = uCan,
        uFat = uFat,
        uInc = uInc
    )
}

fun InfoCadastro.toInfoCadastroEntity(): InfoCadastroEntity {

    return InfoCadastroEntity(
        autorizado = autorizado,
        cImpAPI = cImpAPI,
        cancelado = cancelado,
        dAlt = dAlt,
        dCan = dCan,
        dFat = dFat,
        dInc = dInc,
        denegado = denegado,
        devolvido = devolvido,
        devolvidoParcial = devolvidoParcial,
        faturado = faturado,
        hAlt = hAlt,
        hCan = hCan,
        hFat = hFat,
        hInc = hInc,
        uAlt = uAlt,
        uCan = uCan,
        uFat = uFat,
        uInc = uInc
    )
}

fun ListaParcelasEntity.toListaParcelas(): ListaParcelas {

    return ListaParcelas(
        parcela = parcela?.map { it.toParcela() }
    )
}

fun ListaParcelas.toListaParcelasEntity(): ListaParcelasEntity {

    return ListaParcelasEntity(
        parcela = parcela?.map { it.toParcelaEntity() }
    )
}

fun ParcelaEntity.toParcela(): Parcela {

    return Parcela(
        categoriaAdiantamento = categoriaAdiantamento,
        valor = valor,
        percentual = percentual,
        tipoDocumento = tipoDocumento,
        dataVencimento = dataVencimento,
        numeroParcela = numeroParcela,
        meioPagamento = meioPagamento,
        quantidadeDias = quantidadeDias,
        naoGerarBoleto = naoGerarBoleto,
        parcelaAdiantamento = parcelaAdiantamento,
        contaCorrenteAdiantamento = contaCorrenteAdiantamento
    )
}

fun Parcela.toParcelaEntity(): ParcelaEntity {

    return ParcelaEntity(
        categoriaAdiantamento = categoriaAdiantamento,
        valor = valor,
        percentual = percentual,
        tipoDocumento = tipoDocumento,
        dataVencimento = dataVencimento,
        numeroParcela = numeroParcela,
        meioPagamento = meioPagamento,
        quantidadeDias = quantidadeDias,
        naoGerarBoleto = naoGerarBoleto,
        parcelaAdiantamento = parcelaAdiantamento,
        contaCorrenteAdiantamento = contaCorrenteAdiantamento

    )
}

fun DetEntity.toDet(): Det {

    return Det(
        produto = produto?.toProduto(),
        infAdic = infAdic?.toInfAdic(),
        ide = ide,
        imposto = imposto?.toImposto(),
        observacao = observacao?.toObservacao()
    )
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

fun ImpostoEntity.toImposto(): Imposto {

    return Imposto(
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

fun ObservacaoEntity.toObservacao(): Observacao {

    return Observacao(
        obsItem = obsItem
    )
}

fun Observacao.toObsEntity(): ObservacaoEntity {

    return ObservacaoEntity(
        obsItem = obsItem

    )
}

fun InfAdicEntity.toInfAdic(): InfAdic {

    return InfAdic(
        codigoCategoriaItem = codigoCategoriaItem,
        codigoCenarioImpostosItem = codigoCenarioImpostosItem,
        codigoLocalEstoque = codigoLocalEstoque,
        dadosAdicionaisItem = dadosAdicionaisItem,
        itemPedidoCompra = itemPedidoCompra,
        naoGerarFinanceiro = naoGerarFinanceiro,
        naoMovimentarEstoque = naoMovimentarEstoque,
        numeroPedidoCompra = numeroPedidoCompra,
        pesoBruto = pesoBruto,
        pesoLiquido = pesoLiquido
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

fun ProdutoEntity.toProduto(): Produto {

    return Produto(
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

fun CabecalhoEntity.toCabecalho(): Cabecalho {

    return Cabecalho(
        numeroPedido = numeroPedido,
        bloqueado = bloqueado,
        codigoCenarioImpostos = codigoCenarioImpostos,
        codigoCliente = codigoCliente,
        codigoEmpresa = codigoEmpresa,
        codigoParcela = codigoParcela,
        codigoPedido = codigoPedido,
        codigoPedidoIntegracao = codigoPedidoIntegracao,
        dataPrevisao = dataPrevisao,
        etapa = etapa,
        importadoApi = importadoApi
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
