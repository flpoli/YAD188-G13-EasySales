package com.poli.easysales.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import com.poli.easysales.data.local.dao.ProductRemoteKeyDao
import com.poli.easysales.data.local.dao.ProductsDao
import com.poli.easysales.data.local.entities.ProductsRemoteKeys
import com.poli.easysales.data.remote.dto.produtos.Imagens
import com.poli.easysales.data.util.GsonParser
import com.poli.easysales.domain.mappers.toProdutoEntity
import com.poli.easysales.domain.model.produtos.ProdutoServicoCadastro
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
            .addTypeConverter(DatabaseConverter(GsonParser(Gson())))
            .build()

        productDao = database.productsDao()
        productRemoteKeyDao = database.productRemoteKeysDao()
    }
    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertProduct() = runBlockingTest {

        val produtos = listOf<ProdutoServicoCadastro> (
            ProdutoServicoCadastro(

                codigo = "PRD00001",
                codigoProduto = 100000000,
                codigoProdutoIntegracao = "PRD0001",
                descricao = "LOREM IPSUN",
                descrDetalhada = "LOREM IPSUN",
                quantidadeEstoque = 1,
                unidade = "UN",
                valorUnitario = 100.00,
                altura = 150,
                largura = 150,
                profundidade = 150,
                descricaoFamilia = "teste",
                marca = "teste",
                modelo = "test",
                diasGarantia = 50,
                obsInternas = "obs interna",
                pesoLiq = 5f,
                pesoBruto = 8f,
                imagens = listOf(Imagens(""))

            ),
            ProdutoServicoCadastro(

                codigo = "PRD00002",
                codigoProduto = 100000000,
                codigoProdutoIntegracao = "PRD0002",
                descricao = "LOREM IPSUN",
                descrDetalhada = "LOREM IPSUN",
                quantidadeEstoque = 1,
                unidade = "UN",
                valorUnitario = 100.00,

                altura = 150,
                largura = 150,
                profundidade = 150,
                descricaoFamilia = "teste",
                marca = "teste",
                modelo = "test",
                diasGarantia = 50,
                obsInternas = "obs interna",
                pesoLiq = 5f,
                pesoBruto = 8f,
                imagens = listOf(Imagens())

            )
        )

        productDao.persistProductList(produtos.map { it.toProdutoEntity() })

        val getProduct = productDao.getAllProducts()

        assertThat(getProduct == produtos)
    }
    @Test
    fun deleteAllProducts() = runBlockingTest {
        val produtos = listOf<ProdutoServicoCadastro> (
            ProdutoServicoCadastro(

                codigo = "PRD00001",
                codigoProduto = 100000000,
                codigoProdutoIntegracao = "PRD0001",
                descricao = "LOREM IPSUN",
                descrDetalhada = "LOREM IPSUN",
                quantidadeEstoque = 1,
                unidade = "UN",
                valorUnitario = 100.00,
                altura = 150,
                largura = 150,
                profundidade = 150,
                descricaoFamilia = "teste",
                marca = "teste",
                modelo = "test",
                diasGarantia = 50,
                obsInternas = "obs interna",
                pesoLiq = 5f,
                pesoBruto = 8f,
                imagens = listOf(Imagens())
            ),
            ProdutoServicoCadastro(

                codigo = "PRD00002",
                codigoProduto = 100000000,
                codigoProdutoIntegracao = "PRD0002",
                descricao = "LOREM IPSUN",
                descrDetalhada = "LOREM IPSUN",
                quantidadeEstoque = 1,
                unidade = "UN",
                valorUnitario = 100.00,
                altura = 150,
                largura = 150,
                profundidade = 150,
                descricaoFamilia = "teste",
                marca = "teste",
                modelo = "test",
                diasGarantia = 50,
                obsInternas = "obs interna",
                pesoLiq = 5f,
                pesoBruto = 8f,
                imagens = listOf(Imagens())
            )

        )

        productDao.persistProductList(produtos.map { it.toProdutoEntity() })

        val selectProduct = productDao.deleteAllProducts()

        assertThat(!selectProduct.equals(produtos))
    }
    @Test
    fun insertProductRemoteKeys() = runBlockingTest {

        val remoteKey = listOf(
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

        val getKey = productRemoteKeyDao.getRemoteKeys()

        assertThat(getKey == remoteKey)
    }
}
