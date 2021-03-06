package com.poli.prevendasomie.data.remote.dto.pedidos

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.domain.model.pedidos.Imposto

data class ImpostoDto(
    @SerializedName("cofins_padrao")
    val cofinsPadrao: CofinsPadrao?,
    @SerializedName("cofins_st")
    val cofinsSt: CofinsSt?,
    @SerializedName("csll")
    val csll: Csll?,
    @SerializedName("icms")
    val icms: Icms?,
    @SerializedName("icms_ie")
    val icmsIe: IcmsIe?,
    @SerializedName("icms_sn")
    val icmsSn: IcmsSn?,
    @SerializedName("icms_st")
    val icmsSt: IcmsSt?,
    @SerializedName("inss")
    val inss: Inss?,
    @SerializedName("ipi")
    val ipi: Ipi?,
    @SerializedName("irrf")
    val irrf: Irrf?,
    @SerializedName("iss")
    val iss: Iss?,
    @SerializedName("pis_padrao")
    val pisPadrao: PisPadrao?,
    @SerializedName("pis_st")
    val pisSt: PisSt?
)

fun ImpostoDto.toImposto(): Imposto {

    return Imposto(
        cofinsPadrao = cofinsPadrao,
        cofinsSt = cofinsSt,
        csll = csll,
        icms = icms,
        icmsIe = icmsIe,
        icmsSn = icmsSn,
        icmsSt = icmsSt,
        inss = inss,
        ipi = ipi,
        irrf = irrf,
        iss = iss,
        pisPadrao = pisPadrao,
        pisSt = pisSt
    )
}
