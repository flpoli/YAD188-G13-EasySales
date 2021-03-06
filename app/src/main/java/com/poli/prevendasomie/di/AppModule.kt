package com.poli.prevendasomie.di

import com.google.gson.GsonBuilder
import com.poli.prevendasomie.common.Constants.BASE_ERP_URL
import com.poli.prevendasomie.data.remote.OmieAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    private val gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideOmieApi(client: OkHttpClient): OmieAPI {

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_ERP_URL)
            .client(client)
            .build()
            .create(OmieAPI::class.java)
    }
}
