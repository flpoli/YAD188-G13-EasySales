package com.poli.prevendasomie.data.local.entities.clientes

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.poli.prevendasomie.common.Constants.CLIENTS_TABLE
import com.poli.prevendasomie.presentation.clientes.cliente_form.genCodCli

@Entity(tableName = CLIENTS_TABLE)
data class ClientesCadastroEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val codCliIntegracao: String? = genCodCli(),
    val codClienteOmie: Long? = 0,
    val nomeFantasia: String? = "",
    val razaoSocial: String? = "",
    val cnpjCpf: String? = "",
    val telefone1Ddd: String? = "",
    val telefone1Numero: String? = "",
    var email: String? = "",
    val endereco: String? = "",
    val enderecoNumero: String? = "",
    val bairro: String? = "",
    val cep: String? = "",
    val cidade: String? = "",
    val complemento: String? = ""

)
