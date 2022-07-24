package com.poli.easysales.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.poli.easysales.data.local.dao.ClientDao
import com.poli.easysales.data.local.dao.ClientRemoteKeyDao
import com.poli.easysales.data.local.dao.OrdersDao
import com.poli.easysales.data.local.dao.OrdersRemoteKeyDao
import com.poli.easysales.data.local.dao.ProductRemoteKeyDao
import com.poli.easysales.data.local.dao.ProductsDao
import com.poli.easysales.data.local.dao.UserDao
import com.poli.easysales.data.local.entities.clientes.ClientsRemoteKeys
import com.poli.easysales.data.local.entities.pedidos.OrdersRemoteKeys
import com.poli.easysales.data.local.entities.produtos.ProductsRemoteKeys
import com.poli.easysales.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.easysales.data.local.entities.produtos.ProdutoEntity
import com.poli.easysales.domain.model.UserDataModel
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import com.poli.easysales.domain.model.pedidos.Det

@Database(
    entities = [
        UserDataModel::class,
        ProductsRemoteKeys::class,
        ClientesCadastroEntity::class,
        ClientsRemoteKeys::class,
        ProdutoEntity::class,
        OrdersRemoteKeys::class,
        PedidoVendaProduto::class,

//        Det::class,

//        PedidoVendaEntity::class,
//        ClienteEntity::class

    ],

    version = 1,
    exportSchema = false
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
