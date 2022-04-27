package com.poli.prevendasomie.data.local

import androidx.room.TypeConverter
import com.poli.prevendasomie.data.local.entities.pedidos.OutrosDetalhes

class DatabaseConverter {

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
    fun fromOutrosDetalhes(data: OutrosDetalhes): String {

         val detalhesAsList = listOf(

             data.cBairroOd,
             data.cCEPOd,
             data.cCidadeOd,
             data.cCnpjCpfOd,
             data.cEnderecoOd,
             data.cEstadoOd,
             data.cHoraSaidaOd,
             data.cInscrEstadualOd,
             data.cNomeOd,
             data.cNomeOd,
             data.cTelefoneOd,
             data.dDataSaidaOd


        )

        return convertListToString(detalhesAsList)
    }

//    @TypeConverter
//    fun toOutrosDetalhes(data: String): OutrosDetalhes {
//
//
//
//         return OutrosDetalhes(
//
//         )
//         }
//
//    }
}
