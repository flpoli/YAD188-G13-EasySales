package com.poli.prevendasomie.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.poli.prevendasomie.data.local.dao.ClientDao
import com.poli.prevendasomie.data.local.dao.ClientRemoteKeyDao
import com.poli.prevendasomie.data.local.dao.OrdersDao
import com.poli.prevendasomie.data.local.dao.OrdersRemoteKeyDao
import com.poli.prevendasomie.data.local.dao.ProductRemoteKeyDao
import com.poli.prevendasomie.data.local.dao.ProductsDao
import com.poli.prevendasomie.data.local.dao.UserDao
import com.poli.prevendasomie.domain.model.UserDataModel
import com.poli.prevendasomie.domain.model.produtos.ProductsRemoteKeys
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro

@Database(
    entities = [
        UserDataModel::class,
        ProdutoServicoCadastro::class,
        ProductsRemoteKeys::class,

    ],

    version = 1
)

@TypeConverters(DatabaseConverter::class)
abstract class ErpDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun clientDao(): ClientDao
    abstract fun clientRemoteKeyDao(): ClientRemoteKeyDao
    abstract fun productsDao(): ProductsDao
    abstract fun productRemoteKeysDao(): ProductRemoteKeyDao
    abstract fun ordersDao(): OrdersDao
    abstract fun ordersRemoteKeysDao(): OrdersRemoteKeyDao
}
