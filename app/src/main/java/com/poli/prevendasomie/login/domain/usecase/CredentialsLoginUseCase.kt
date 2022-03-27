package com.poli.prevendasomie.login.domain.usecase

import com.poli.prevendasomie.login.domain.model.Credentials
import com.poli.prevendasomie.login.domain.model.LoginResult

interface CredentialsLoginUseCase {

    suspend operator fun invoke(credentials: Credentials): LoginResult
}
