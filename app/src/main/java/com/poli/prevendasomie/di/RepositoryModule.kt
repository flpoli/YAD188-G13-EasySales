package com.poli.prevendasomie.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.poli.prevendasomie.data.local.UserDatabase
import com.poli.prevendasomie.data.local.dao.UserDao
import com.poli.prevendasomie.data.remote.BackEndApi
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.data.repository.ClientsRepositoryImpl
import com.poli.prevendasomie.data.repository.DataStoreOperationsImpl
import com.poli.prevendasomie.data.repository.OrdersRepositoryImpl
import com.poli.prevendasomie.data.repository.ProductsRepositoryImpl
import com.poli.prevendasomie.domain.repository.ClientsRepository
import com.poli.prevendasomie.domain.repository.DataStoreOperations
import com.poli.prevendasomie.domain.repository.OrdersRepository
import com.poli.prevendasomie.domain.repository.ProductsRepository
import com.poli.prevendasomie.login.domain.repository.LoginRepository
import com.poli.prevendasomie.login.domain.repository.LoginRepositoryImpl
import com.poli.prevendasomie.login.domain.repository.TokenRepository
import com.poli.prevendasomie.login.domain.repository.TokenRepositoryImpl
import com.poli.prevendasomie.signup.domain.repository.SignUpRepository
import com.poli.prevendasomie.signup.domain.repository.SignUpRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(@ApplicationContext context: Context): DataStoreOperations {
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideDatabase(app: Application): UserDatabase {

        return Room.databaseBuilder(
            app,
            UserDatabase::class.java,
            "UserDatabase"
        ).build()
    }

    @Provides
    @Singleton
    fun provideUserDao(db: UserDatabase) = db.userDao()

    @Provides
    @Singleton
    fun provideLoginRepository(api: BackEndApi, dao: UserDao): LoginRepository {
        return LoginRepositoryImpl(api, dao)
    }

    @Provides
    @Singleton
    fun provideTokenRepository(dataStore: DataStoreOperations): TokenRepository {
        return TokenRepositoryImpl(dataStore)
    }
    @Provides
    @Singleton
    fun provideSignUpRepository(api: BackEndApi): SignUpRepository {
        return SignUpRepositoryImpl(api)
    }
    @Provides
    @Singleton
    fun provideClientsRepository(api: OmieAPI): ClientsRepository {

        return ClientsRepositoryImpl(api)
    }
    @Provides
    @Singleton
    fun provideProductsRepository(api: OmieAPI): ProductsRepository {

        return ProductsRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideOrdersRepository(api: OmieAPI): OrdersRepository {

        return OrdersRepositoryImpl(api)
    }
}
