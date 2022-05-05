package com.poli.prevendasomie.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.poli.prevendasomie.data.local.entities.pedidos.CabecalhoEntity
import com.poli.prevendasomie.data.local.entities.pedidos.FreteEntity
import com.poli.prevendasomie.data.local.entities.pedidos.InfoCadastroEntity
import com.poli.prevendasomie.data.util.JsonParser
import com.poli.prevendasomie.domain.model.pedidos.Det
import com.poli.prevendasomie.domain.model.pedidos.InformacoesAdicionais
import com.poli.prevendasomie.domain.model.pedidos.ListaParcelas
import com.poli.prevendasomie.domain.model.pedidos.OutrosDetalhes
import com.poli.prevendasomie.domain.model.pedidos.Parcela
import com.poli.prevendasomie.domain.model.pedidos.TotalPedido

@ProvidedTypeConverter
class DatabaseConverter(
    private val jsonParser: JsonParser
) {

    private val separator = ","

    @TypeConverter
    fun convertListToString(list: List<String?>): String {

        val stringBuilder = StringBuilder()

        for (item in list) {
            stringBuilder.append(item).append(separator)
        }

        stringBuilder.setLength(stringBuilder.length - separator.length)
        return stringBuilder.toString()
    }

    @TypeConverter
    fun convertStringToList(string: String): List<String> {

        return string.split(separator)
    }

//    @TypeConverter
//    fun fromCabecalhoJson(json: String): Cabecalho? {
//
//        return jsonParser.fromJson<Cabecalho>(
//            json = json,
//            type = object : TypeToken<Cabecalho>(){}.type
//        )
//
//    }
//    @TypeConverter
//    fun toCabecalhoJson(cabecalho: Cabecalho): String? {
//
//        return jsonParser.toJson(
//            obj = cabecalho,
//            type = object : TypeToken<Cabecalho>() {}.type
//        )
//
//    }

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
    fun fromParcelaJson(json: String): List<Parcela> {

        return jsonParser.fromJson<ArrayList<Parcela>>(

            json = json,
            type = object : TypeToken<ArrayList<Parcela>>() {}.type

        ) ?: emptyList()
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
