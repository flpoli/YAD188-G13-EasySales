package com.poli.easysales.domain.usecase.clients

import com.poli.easysales.common.Resource
import com.poli.easysales.data.remote.dto.ReqResponse

interface DeleteClientByCodeUseCase {

    suspend operator fun invoke(codCli: Long): Resource<ReqResponse?>
}