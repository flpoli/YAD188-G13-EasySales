package com.poli.prevendasomie.domain.model.pedidos

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.data.remote.dto.pedidos.CofinsPadrao
import com.poli.prevendasomie.data.remote.dto.pedidos.CofinsSt
import com.poli.prevendasomie.data.remote.dto.pedidos.Csll
import com.poli.prevendasomie.data.remote.dto.pedidos.Icms
import com.poli.prevendasomie.data.remote.dto.pedidos.IcmsIe
import com.poli.prevendasomie.data.remote.dto.pedidos.IcmsSn
import com.poli.prevendasomie.data.remote.dto.pedidos.IcmsSt
import com.poli.prevendasomie.data.remote.dto.pedidos.Inss
import com.poli.prevendasomie.data.remote.dto.pedidos.Ipi
import com.poli.prevendasomie.data.remote.dto.pedidos.Irrf
import com.poli.prevendasomie.data.remote.dto.pedidos.Iss
import com.poli.prevendasomie.data.remote.dto.pedidos.PisPadrao
import com.poli.prevendasomie.data.remote.dto.pedidos.PisSt

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
