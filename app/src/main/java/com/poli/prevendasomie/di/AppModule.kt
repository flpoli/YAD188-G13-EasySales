package com.poli.prevendasomie.di

import android.content.Context
import com.google.gson.GsonBuilder
import com.poli.prevendasomie.data.remote.HttpRoutes.BASE_URL
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.data.repository.ClientsRepositoryImpl
import com.poli.prevendasomie.data.repository.DataStoreOperationsImpl
import com.poli.prevendasomie.domain.repository.ClientsRepository
import com.poli.prevendasomie.domain.repository.DataStoreOperations
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    private val gson = GsonBuilder().create() // no no no no

    @Provides
    @Singleton
    fun provideOmieApi(client: OkHttpClient): OmieAPI {

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .client(client)
            .build()
            .create(OmieAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideClientsRepository(api: OmieAPI): ClientsRepository {

        return ClientsRepositoryImpl(api)
    }

}
