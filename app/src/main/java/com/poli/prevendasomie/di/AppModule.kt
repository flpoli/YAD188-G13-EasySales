package com.poli.prevendasomie.di

import com.google.gson.GsonBuilder
import com.poli.prevendasomie.data.remote.HttpRoutes.BASE_URL
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.repository.ClientsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
 private val gson = GsonBuilder().create() // no no no no
    @Provides
    @Singleton
    fun provideOmieApi(): OmieAPI{

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .build()
            .create(OmieAPI::class.java)

    }

    @Provides
    @Singleton
    fun provideClientsRepository(
        api: OmieAPI
    ) = ClientsRepository(api)

}