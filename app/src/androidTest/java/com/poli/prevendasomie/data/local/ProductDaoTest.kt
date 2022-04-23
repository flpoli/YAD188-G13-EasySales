package com.poli.prevendasomie.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.poli.prevendasomie.data.local.dao.ProductRemoteKeyDao
import com.poli.prevendasomie.data.local.dao.ProductsDao
import com.poli.prevendasomie.domain.model.produtos.ProductsRemoteKeys
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class ProductDaoTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: ErpDatabase
    private lateinit var productDao: ProductsDao
    private lateinit var productRemoteKeyDao: ProductRemoteKeyDao

    @Before
    fun setup() {

        database = Room
            .inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                ErpDatabase::class.java
            )
            .allowMainThreadQueries()
            .build()

        productDao = database.productsDao()

    }
    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertProduct() = runBlockingTest {

        val produtos = listOf<ProdutoServicoCadastro> (
            ProdutoServicoCadastro(
                key = 1,
                codigo = "PRD00001",
                codigoProduto = 100000000,
                codigoProdutoIntegracao = "PRD0001",
                descricao = "LOREM IPSUN",
                descrDetalhada = "LOREM IPSUN",
                quantidadeEstoque = 1,
                unidade = "UN",
                valorUnitario = 100.00
            ),
            ProdutoServicoCadastro(
                key = 2,
                codigo = "PRD00002",
                codigoProduto = 100000000,
                codigoProdutoIntegracao = "PRD0002",
                descricao = "LOREM IPSUN",
                descrDetalhada = "LOREM IPSUN",
                quantidadeEstoque = 1,
                unidade = "UN",
                valorUnitario = 100.00
            )

        )

        productDao.persistProductList(produtos)

        val getProduct = productDao.getAllProducts()

        assertThat(getProduct == produtos)
    }
    @Test
    fun deleteAllProducts() = runBlockingTest {
        val produtos = listOf<ProdutoServicoCadastro> (
            ProdutoServicoCadastro(
                key = 1,
                codigo = "PRD00001",
                codigoProduto = 100000000,
                codigoProdutoIntegracao = "PRD0001",
                descricao = "LOREM IPSUN",
                descrDetalhada = "LOREM IPSUN",
                quantidadeEstoque = 1,
                unidade = "UN",
                valorUnitario = 100.00
            ),
            ProdutoServicoCadastro(
                key = 2,
                codigo = "PRD00002",
                codigoProduto = 100000000,
                codigoProdutoIntegracao = "PRD0002",
                descricao = "LOREM IPSUN",
                descrDetalhada = "LOREM IPSUN",
                quantidadeEstoque = 1,
                unidade = "UN",
                valorUnitario = 100.00
            )

        )

        productDao.persistProductList(produtos)

        val selectProduct = productDao.deleteAllProducts()

        assertThat(!selectProduct.equals(produtos))
    }
    @Test
    fun insertProductRemoteKeys() = runBlockingTest {

        val remoteKey =listOf(
            ProductsRemoteKeys(
                id = 1,
                prevPage = 1,
                nextPage = 1,
                lastUpdated = 1000L
            ),
            ProductsRemoteKeys(
                id = 2,
                prevPage = 1,
                nextPage = 3,
                lastUpdated = 1000L
            )
        )

        productRemoteKeyDao.addAllRemoteKeys(remoteKey)

        val getKey = productRemoteKeyDao.getRemoteKeys(1)

        assertThat(getKey == remoteKey[0])
    }
}
