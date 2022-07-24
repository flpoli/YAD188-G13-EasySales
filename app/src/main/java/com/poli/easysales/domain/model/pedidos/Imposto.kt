package com.poli.easysales.domain.model.pedidos

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName
import com.poli.easysales.data.remote.dto.pedidos.CofinsPadrao
import com.poli.easysales.data.remote.dto.pedidos.CofinsSt
import com.poli.easysales.data.remote.dto.pedidos.Csll
import com.poli.easysales.data.remote.dto.pedidos.Icms
import com.poli.easysales.data.remote.dto.pedidos.IcmsIe
import com.poli.easysales.data.remote.dto.pedidos.IcmsSn
import com.poli.easysales.data.remote.dto.pedidos.IcmsSt
import com.poli.easysales.data.remote.dto.pedidos.Inss
import com.poli.easysales.data.remote.dto.pedidos.Ipi
import com.poli.easysales.data.remote.dto.pedidos.Irrf
import com.poli.easysales.data.remote.dto.pedidos.Iss
import com.poli.easysales.data.remote.dto.pedidos.PisPadrao
import com.poli.easysales.data.remote.dto.pedidos.PisSt

data class Imposto(
    @Embedded val cofinsPadrao: CofinsPadrao? = null,
    @Embedded val cofinsSt: CofinsSt? = null,
    @Embedded val csll: Csll? = null,
    @Embedded val icms: Icms? = null,
    @Embedded val icmsIe: IcmsIe? = null,
    @Embedded val icmsSn: IcmsSn? = null,
    @Embedded val icmsSt: IcmsSt? = null,
    @Embedded val inss: Inss? = null,
    @Embedded val ipi: Ipi? = null,
    @Embedded val irrf: Irrf? = null,
    @Embedded val iss: Iss? = null,
    @Embedded val pisPadrao: PisPadrao? = null,
    @Embedded val pisSt: PisSt? = null
)
