package com.poli.easysales.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.poli.easysales.data.local.entities.pedidos.CabecalhoEntity
import com.poli.easysales.data.local.entities.pedidos.DetEntity
import com.poli.easysales.data.local.entities.pedidos.FreteEntity
import com.poli.easysales.data.local.entities.pedidos.InfoCadastroEntity
import com.poli.easysales.data.local.entities.pedidos.ListaParcelasEntity
import com.poli.easysales.data.local.entities.pedidos.OutrosDetalhes
import com.poli.easysales.data.local.entities.pedidos.Parcela
import com.poli.easysales.data.local.entities.pedidos.TotalPedidoEntity
import com.poli.easysales.data.remote.dto.produtos.Imagens
import com.poli.easysales.data.util.JsonParser
import com.poli.easysales.domain.model.clientes.Tag
import com.poli.easysales.domain.model.pedidos.InformacoesAdicionais


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
    fun fromTotalPedidoJson(json: String): TotalPedidoEntity? {

        return jsonParser.fromJson<TotalPedidoEntity>(
            json = json,
            type = object : TypeToken<TotalPedidoEntity>() {}.type
        )
    }

    @TypeConverter
    fun toTotalPedidoJson(totalPedido: TotalPedidoEntity): String? {

        return jsonParser.toJson(
            obj = totalPedido,
            type = object : TypeToken<TotalPedidoEntity>() {}.type
        )
    }

    @TypeConverter
    fun fromImagensJson(json: String): List<Imagens> {
        return jsonParser.fromJson<ArrayList<Imagens>>(
            json,
            object : TypeToken<ArrayList<Imagens>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toImagensJson(meanings: List<Imagens>): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<Imagens>>() {}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromListaParcelasJson(json: String): ListaParcelasEntity? {

        return jsonParser.fromJson<ListaParcelasEntity>(
            json = json,
            type = object : TypeToken<ListaParcelasEntity>() {}.type

        )
    }
    @TypeConverter
    fun toListarParcelasJson(listaParcelas: ListaParcelasEntity): String? {

        return jsonParser.toJson(
            obj = listaParcelas,
            type = object : TypeToken<ListaParcelasEntity>() {}.type
        )
    }

    @TypeConverter
    fun toTagsJson(tags: List<Tag>): String {

        return jsonParser.toJson(
            obj = tags,
            type = object : TypeToken<ArrayList<Tag>>() {}.type
        ) ?: "[]"
    }
    @TypeConverter
    fun fromTagsJson(json: String): List<Tag> {

        return jsonParser.fromJson<ArrayList<Tag>>(

            json = json,
            type = object : TypeToken<ArrayList<Tag>>() {}.type

        ) ?: emptyList()
    }

    @TypeConverter
    fun toDetJson(det: List<DetEntity>): String {
        return jsonParser.toJson(
            obj = det,
            type = object : TypeToken<ArrayList<DetEntity>>() {}.type
        ) ?: "[]"
    }
    @TypeConverter
    fun fromDetJson(json: String): List<DetEntity> {

        return jsonParser.fromJson<ArrayList<DetEntity>>(

            json = json,
            type = object : TypeToken<ArrayList<DetEntity>>() {}.type

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
