package com.poli.prevendasomie.domain.model.clientes

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.presentation.clientes.cliente_form.genCodCli

@JvmInline
value class Email(val value: String)

@Entity(tableName = "clients_table")
data class ClientesCadastro(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @SerializedName("codigo_cliente_integracao")
    val codCliIntegracao: String? = genCodCli(),
    @SerializedName("codigo_cliente_omie")
    val codClienteOmie: Long? = 0,
    @SerializedName("nome_fantasia")
    val nomeFantasia: String? = "",
    @SerializedName("razao_social")
    val razaoSocial: String? = "",
    @SerializedName("cnpj_cpf")
    val cnpjCpf: String? = "",
    @SerializedName("telefone1_ddd")
    val telefone1Ddd: String? = "",
    @SerializedName("telefone1_numero")
    val telefone1Numero: String? = "",
    @SerializedName("email")
    var email: String? = "",
    @SerializedName("endereco")
    val endereco: String? = "",
    @SerializedName("endereco_numero")
    val enderecoNumero: String? = "",
    @SerializedName("bairro")
    val bairro: String? = "",
    @SerializedName("cep")
    val cep: String? = "",
    @SerializedName("cidade")
    val cidade: String? = "",
    @SerializedName("complemento")
    val complemento: String? = ""

)
