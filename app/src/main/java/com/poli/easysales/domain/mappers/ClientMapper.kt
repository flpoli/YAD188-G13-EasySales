package com.poli.easysales.domain.mappers

import com.poli.easysales.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.easysales.data.remote.dto.clientes.ClientesCadastroDto
import com.poli.easysales.domain.model.clientes.ClientesCadastro

fun ClientesCadastroEntity.toClientModel(): ClientesCadastro {

    return ClientesCadastro(
        codCliIntegracao = codCliIntegracao,
        codClienteOmie = codClienteOmie,
        nomeFantasia = nomeFantasia,
        razaoSocial = razaoSocial,
        cnpjCpf = cnpjCpf,
        telefone1Ddd = telefone1Ddd,
        telefone1Numero = telefone1Numero,
        email = email,
        endereco = endereco,
        estado = estado,
        enderecoNumero = enderecoNumero,
        bairro = bairro,
        cep = cep,
        cidade = cidade,
        complemento = complemento
    )
}

fun ClientesCadastro.toClientEntity(): ClientesCadastroEntity {

    return ClientesCadastroEntity(
        codCliIntegracao = codCliIntegracao,
        codClienteOmie = codClienteOmie,
        nomeFantasia = nomeFantasia,
        razaoSocial = razaoSocial,
        cnpjCpf = cnpjCpf,
        telefone1Ddd = telefone1Ddd,
        telefone1Numero = telefone1Numero,
        email = email,
        endereco = endereco,
        estado = estado,
        enderecoNumero = enderecoNumero,
        bairro = bairro,
        cep = cep,
        cidade = cidade,
        complemento = complemento

    )
}

fun ClientesCadastro.toClientDto(): ClientesCadastroDto {

    return ClientesCadastroDto(
        codigoClienteIntegracao = codCliIntegracao,
        codigoClienteOmie = codClienteOmie,
        nomeFantasia = nomeFantasia,
        razaoSocial = razaoSocial,
        cnpjCpf = cnpjCpf,
        telefone1Ddd = telefone1Ddd,
        telefone1Numero = telefone1Numero,
        email = email,
        endereco = endereco,
        estado = estado,
        enderecoNumero = enderecoNumero,
        bairro = bairro,
        cep = cep,
        cidade = cidade,
        complemento = complemento
    )
}

fun ClientesCadastroDto.toClienteModel(): ClientesCadastro {

    return ClientesCadastro(

        codCliIntegracao = codigoClienteIntegracao,
        codClienteOmie = codigoClienteOmie,
        nomeFantasia = nomeFantasia,
        razaoSocial = razaoSocial,
        cnpjCpf = cnpjCpf,
        telefone1Ddd = telefone1Ddd,
        telefone1Numero = telefone1Numero,
        email = email,
        endereco = endereco,
        enderecoNumero = enderecoNumero,
        bairro = bairro,
        estado = estado,
        cep = cep,
        cidade = cidade,
        complemento = complemento
    )
}
