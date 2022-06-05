package com.poli.easysales.domain.mappers

import com.poli.easysales.data.local.entities.produtos.ProdutoEntity
import com.poli.easysales.data.remote.dto.produtos.ProdutoServicoCadastroDto
import com.poli.easysales.domain.model.produtos.ProdutoServicoCadastro

fun ProdutoServicoCadastro.toProdutoDto(): ProdutoServicoCadastroDto {

    return ProdutoServicoCadastroDto(

        codigo = codigo,
        codigoProduto = codigoProduto,
        codigoProdutoIntegracao = codigoProdutoIntegracao,
        descricao = descricao,
        descrDetalhada = descrDetalhada,
        quantidadeEstoque = quantidadeEstoque,
        unidade = unidade,
        valorUnitario = valorUnitario,
        imagens = imagens

    )
}

fun ProdutoServicoCadastro.toProdutoEntity(): ProdutoEntity {

    return ProdutoEntity(
        codigo = codigo,
        codigoProduto = codigoProduto,
        codigoProdutoIntegracao = codigoProdutoIntegracao,
        descricao = descricao,
        descrDetalhada = descrDetalhada,
        quantidadeEstoque = quantidadeEstoque,
        unidade = unidade,
        valorUnitario = valorUnitario,
        imagens = imagens,

        descricaoFamilia = descricaoFamilia,
        diasGarantia = diasGarantia,
        altura = altura,
        largura = largura,
        profundidade = profundidade,
        marca = marca,
        modelo = modelo,
        pesoBruto = pesoBruto,
        pesoLiq = pesoLiq,
        obsInternas = obsInternas

    )
}

fun ProdutoEntity.toProdutoModel(): ProdutoServicoCadastro {

    return ProdutoServicoCadastro(
        codigo = codigo,
        codigoProduto = codigoProduto,
        codigoProdutoIntegracao = codigoProdutoIntegracao,
        descricao = descricao,
        descrDetalhada = descrDetalhada,
        quantidadeEstoque = quantidadeEstoque,
        unidade = unidade,
        valorUnitario = valorUnitario,
        imagens = imagens,

        descricaoFamilia = descricaoFamilia,
        diasGarantia = diasGarantia,
        altura = altura,
        largura = largura,
        profundidade = profundidade,
        marca = marca,
        modelo = modelo,
        pesoBruto = pesoBruto,
        pesoLiq = pesoLiq,
        obsInternas = obsInternas
    )
}

fun ProdutoServicoCadastroDto.toProdutoCadastro(): ProdutoServicoCadastro {

    return ProdutoServicoCadastro(

        codigo = codigo,
        codigoProduto = codigoProduto,
        codigoProdutoIntegracao = codigoProdutoIntegracao,
        descricao = descricao,
        descrDetalhada = descrDetalhada,
        quantidadeEstoque = quantidadeEstoque,
        unidade = unidade,
        valorUnitario = valorUnitario,
        imagens = imagens,

        descricaoFamilia = descricaoFamilia,
        diasGarantia = diasGarantia,
        altura = altura,
        largura = largura,
        profundidade = profundidade,
        marca = marca,
        modelo = modelo,
        pesoBruto = pesoBruto,
        pesoLiq = pesoLiq,
        obsInternas = obsInternas

    )
}
