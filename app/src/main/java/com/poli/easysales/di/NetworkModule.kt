package com.poli.easysales.di

import com.poli.easysales.common.Constants.BASE_CEP_URL
import com.poli.easysales.common.Constants.LOGIN_URL
import com.poli.easysales.data.remote.BackEndApi
import com.poli.easysales.data.remote.CepApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {

        return OkHttpClient
            .Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    @Singleton
    @Provides
    fun provideLoginApi(client: OkHttpClient): BackEndApi {

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(LOGIN_URL)
            .client(client)
            .build()
            .create(BackEndApi::class.java)
    }

    @Singleton
    @Provides
    fun provideViaCepApi(client: OkHttpClient): CepApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_CEP_URL)
            .client(client)
            .build()
            .create(CepApi::class.java)
    }

}
