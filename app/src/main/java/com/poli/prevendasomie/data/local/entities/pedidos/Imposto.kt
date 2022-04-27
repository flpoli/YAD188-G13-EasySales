package com.poli.prevendasomie.data.local.entities.pedidos

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.data.remote.responses.pedidos.CofinsPadrao
import com.poli.prevendasomie.data.remote.responses.pedidos.CofinsSt
import com.poli.prevendasomie.data.remote.responses.pedidos.Csll
import com.poli.prevendasomie.data.remote.responses.pedidos.Icms
import com.poli.prevendasomie.data.remote.responses.pedidos.IcmsIe
import com.poli.prevendasomie.data.remote.responses.pedidos.IcmsSn
import com.poli.prevendasomie.data.remote.responses.pedidos.IcmsSt
import com.poli.prevendasomie.data.remote.responses.pedidos.Inss
import com.poli.prevendasomie.data.remote.responses.pedidos.Ipi
import com.poli.prevendasomie.data.remote.responses.pedidos.Irrf
import com.poli.prevendasomie.data.remote.responses.pedidos.Iss
import com.poli.prevendasomie.data.remote.responses.pedidos.PisPadrao
import com.poli.prevendasomie.data.remote.responses.pedidos.PisSt

data class Imposto(
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
