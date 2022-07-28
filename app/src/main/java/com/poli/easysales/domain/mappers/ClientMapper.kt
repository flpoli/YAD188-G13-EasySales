package com.poli.easysales.domain.mappers

import com.poli.easysales.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.easysales.data.remote.dto.clientes.CaracteristicaDto
import com.poli.easysales.data.remote.dto.clientes.ClientesCadastroDto
import com.poli.easysales.data.remote.dto.clientes.TagDto
import com.poli.easysales.domain.model.clientes.Caracteristica
import com.poli.easysales.domain.model.clientes.ClientesCadastro
import com.poli.easysales.domain.model.clientes.Tag

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
        complemento = complemento,
        tags = tags
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
        complemento = complemento,
        tags = tags

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
        complemento = complemento,
        tags = tags?.map { TagDto(it.tag) }
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
        complemento = complemento,
        tags = tags?.map { Tag(it.tag) }
    )
}

fun CaracteristicaDto.toCaracteristicaModel(): Caracteristica {

    return Caracteristica(campo = campo, conteudo = conteudo)
}
