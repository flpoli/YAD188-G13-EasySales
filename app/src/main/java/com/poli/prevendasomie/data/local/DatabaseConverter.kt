package com.poli.prevendasomie.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.poli.prevendasomie.data.local.entities.pedidos.OutrosDetalhes
import com.poli.prevendasomie.data.util.JsonParser
import com.poli.prevendasomie.domain.model.pedidos.Cabecalho
import com.poli.prevendasomie.domain.model.pedidos.Frete
import com.poli.prevendasomie.domain.model.pedidos.InfoCadastro
import com.poli.prevendasomie.domain.model.pedidos.InformacoesAdicionais
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


    @TypeConverter
    fun fromCabecalhoJson(json: String): Cabecalho? {

        return jsonParser.fromJson<Cabecalho>(
            json = json,
            type = object : TypeToken<Cabecalho>(){}.type
        )

    }
    @TypeConverter
    fun toCabecalhoJson(cabecalho: Cabecalho): String? {

        return jsonParser.toJson(
            obj = cabecalho,
            type = object : TypeToken<Cabecalho>() {}.type
        )

    }

    @TypeConverter
    fun fromFreteJson(json: String): Frete? {

        return jsonParser.fromJson<Frete>(
            json = json,
            type = object : TypeToken<Frete>(){}.type
        )

    }

    @TypeConverter
    fun toCabecalhoJson(frete: Frete): String? {

        return jsonParser.toJson(
            obj = frete,
            type = object : TypeToken<Frete>() {}.type
        )

    }

    @TypeConverter
    fun fromInfoCadastroJson(json: String): InfoCadastro? {

        return jsonParser.fromJson<InfoCadastro>(
            json = json,
            type = object : TypeToken<InfoCadastro>(){}.type
        )

    }

    @TypeConverter
    fun toInfoCadastroJson(infoCadastro: InfoCadastro): String? {

        return jsonParser.toJson(
            obj = infoCadastro,
            type = object : TypeToken<InfoCadastro>() {}.type
        )

    }

    @TypeConverter
    fun fromInformacoesAdicionaisJson(json: String): InformacoesAdicionais? {

        return jsonParser.fromJson<InformacoesAdicionais>(
            json = json,
            type = object : TypeToken<InformacoesAdicionais>(){}.type
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
            type = object : TypeToken<TotalPedido>(){}.type
        )

    }

    @TypeConverter
    fun toTotalPedidoJson(totalPedido: TotalPedido): String? {

        return jsonParser.toJson(
            obj = totalPedido,
            type = object : TypeToken<TotalPedido>() {}.type
        )

    }
}
