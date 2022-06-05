package com.poli.easysales.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.poli.easysales.data.local.entities.pedidos.CabecalhoEntity
import com.poli.easysales.data.local.entities.pedidos.FreteEntity
import com.poli.easysales.data.local.entities.pedidos.InfoCadastroEntity
import com.poli.easysales.data.remote.dto.produtos.Imagens
import com.poli.easysales.data.util.JsonParser
import com.poli.easysales.domain.model.pedidos.Det
import com.poli.easysales.domain.model.pedidos.InformacoesAdicionais
import com.poli.easysales.domain.model.pedidos.ListaParcelas
import com.poli.easysales.domain.model.pedidos.OutrosDetalhes
import com.poli.easysales.domain.model.pedidos.Parcela
import com.poli.easysales.domain.model.pedidos.TotalPedido

@ProvidedTypeConverter
class DatabaseConverter(
    private val jsonParser: JsonParser
) {

    @TypeConverter
    fun fromCabecalhoEntityJson(json: String): CabecalhoEntity? {

        return jsonParser.fromJson<CabecalhoEntity>(
            json = json,
            type = object : TypeToken<CabecalhoEntity>() {}.type
        )
    }
    @TypeConverter
    fun toCabecalhoEntityJson(cabecalho: CabecalhoEntity): String? {

        return jsonParser.toJson(
            obj = cabecalho,
            type = object : TypeToken<CabecalhoEntity>() {}.type
        )
    }

    @TypeConverter
    fun fromFreteJson(json: String): FreteEntity? {

        return jsonParser.fromJson<FreteEntity>(
            json = json,
            type = object : TypeToken<FreteEntity>() {}.type
        )
    }

    @TypeConverter
    fun toCabecalhoJson(frete: FreteEntity): String? {

        return jsonParser.toJson(
            obj = frete,
            type = object : TypeToken<FreteEntity>() {}.type
        )
    }

    @TypeConverter
    fun fromInfoCadastroJson(json: String): InfoCadastroEntity? {

        return jsonParser.fromJson<InfoCadastroEntity>(
            json = json,
            type = object : TypeToken<InfoCadastroEntity>() {}.type
        )
    }

    @TypeConverter
    fun toInfoCadastroJson(infoCadastro: InfoCadastroEntity): String? {

        return jsonParser.toJson(
            obj = infoCadastro,
            type = object : TypeToken<InfoCadastroEntity>() {}.type
        )
    }

    @TypeConverter
    fun toOutrosDetalhesJson(outrosDetalhes: OutrosDetalhes): String? {

        return jsonParser.toJson(
            obj = outrosDetalhes,
            type = object : TypeToken<OutrosDetalhes>() {}.type
        )
    }
    @TypeConverter
    fun fromOutrosDetalhesJson(json: String): OutrosDetalhes? {

        return jsonParser.fromJson<OutrosDetalhes>(
            json = json,
            type = object : TypeToken<OutrosDetalhes>() {}.type
        )
    }

    @TypeConverter
    fun fromInformacoesAdicionaisJson(json: String): InformacoesAdicionais? {

        return jsonParser.fromJson<InformacoesAdicionais>(
            json = json,
            type = object : TypeToken<InformacoesAdicionais>() {}.type
        )
    }

    @TypeConverter
    fun toInformacoesAdicionaisJson(infoAdicionais: InformacoesAdicionais): String? {

        return jsonParser.toJson(
            obj = infoAdicionais,
            type = object : TypeToken<InformacoesAdicionais>() {}.type
        )
    }

    @TypeConverter
    fun fromTotalPedidoJson(json: String): TotalPedido? {

        return jsonParser.fromJson<TotalPedido>(
            json = json,
            type = object : TypeToken<TotalPedido>() {}.type
        )
    }

    @TypeConverter
    fun toTotalPedidoJson(totalPedido: TotalPedido): String? {

        return jsonParser.toJson(
            obj = totalPedido,
            type = object : TypeToken<TotalPedido>() {}.type
        )
    }

    @TypeConverter
    fun fromMeaningsJson(json: String): List<Imagens> {
        return jsonParser.fromJson<ArrayList<Imagens>>(
            json,
            object : TypeToken<ArrayList<Imagens>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toMeaningsJson(meanings: List<Imagens>): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<Imagens>>() {}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromListaParcelasJson(json: String): ListaParcelas? {

        return jsonParser.fromJson<ListaParcelas>(
            json = json,
            type = object : TypeToken<ListaParcelas>() {}.type

        )
    }
    @TypeConverter
    fun toListarParcelasJson(listaParcelas: ListaParcelas): String? {

        return jsonParser.toJson(
            obj = listaParcelas,
            type = object : TypeToken<ListaParcelas>() {}.type
        )
    }

    @TypeConverter
    fun toDetJson(det: List<Det>): String {
        return jsonParser.toJson(
            obj = det,
            type = object : TypeToken<ArrayList<Det>>() {}.type
        ) ?: "[]"
    }
    @TypeConverter
    fun fromDetJson(json: String): List<Det> {

        return jsonParser.fromJson<ArrayList<Det>>(

            json = json,
            type = object : TypeToken<ArrayList<Det>>() {}.type

        ) ?: emptyList()
    }

    @TypeConverter
    fun toParcelaJson(parcela: List<Parcela>): String {
        return jsonParser.toJson(
            obj = parcela,
            type = object : TypeToken<ArrayList<Parcela>>() {}.type
        ) ?: "[]"
    }
}
