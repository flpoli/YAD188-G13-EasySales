package com.poli.easysales.login.domain.usecase

import com.poli.easysales.login.domain.model.Credentials
import com.poli.easysales.login.domain.model.LoginResult

interface CredentialsLoginUseCase {

    suspend operator fun invoke(credentials: Credentials): LoginResult
}
