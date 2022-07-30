package com.poli.easysales.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.poli.easysales.data.local.dao.CategoriaDao
import com.poli.easysales.data.local.dao.ClientDao
import com.poli.easysales.data.local.dao.ClientRemoteKeyDao
import com.poli.easysales.data.local.dao.OrdersDao
import com.poli.easysales.data.local.dao.OrdersRemoteKeyDao
import com.poli.easysales.data.local.dao.ProductRemoteKeyDao
import com.poli.easysales.data.local.dao.ProductsDao
import com.poli.easysales.data.local.dao.UserDao
import com.poli.easysales.data.local.entities.categorias.CategoriaEntity
import com.poli.easysales.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.easysales.data.local.entities.clientes.ClientsRemoteKeys
import com.poli.easysales.data.local.entities.pedidos.OrdersRemoteKeys
import com.poli.easysales.data.local.entities.pedidos.PedidoVendaProdutoEntity
import com.poli.easysales.data.local.entities.produtos.ProductsRemoteKeys
import com.poli.easysales.data.local.entities.produtos.ProdutoVendaEntity
import com.poli.easysales.domain.model.UserDataModel

@Database(
    version = 1,
    entities = [
        UserDataModel::class,
        ProductsRemoteKeys::class,
        ClientesCadastroEntity::class,
        ClientsRemoteKeys::class,
        ProdutoVendaEntity::class,
        OrdersRemoteKeys::class,
        PedidoVendaProdutoEntity::class,
        CategoriaEntity::class
    ],

//    autoMigrations = [
//        AutoMigration (from = 1, to = 2)
//    ],

    exportSchema = true
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

    abstract fun categoryDao(): CategoriaDao
}
