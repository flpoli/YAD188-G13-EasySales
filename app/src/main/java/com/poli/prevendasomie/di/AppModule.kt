package com.poli.prevendasomie.di

import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.data.remote.OmieApiImpl
import com.poli.prevendasomie.data.repository.ClientsRepositoryImpl
import com.poli.prevendasomie.domain.repository.ClientsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideOmieApi(): OmieAPI{
        return OmieApiImpl(HttpClient(Android))
    }

    @Provides
    @Singleton
    fun provideClientsRepository(api: OmieAPI): ClientsRepository {

        return ClientsRepositoryImpl(api)

    }

}