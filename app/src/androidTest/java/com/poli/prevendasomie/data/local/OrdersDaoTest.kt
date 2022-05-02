package com.poli.prevendasomie.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.poli.prevendasomie.data.local.dao.OrdersDao
import com.poli.prevendasomie.domain.model.pedidos.Cabecalho
import com.poli.prevendasomie.domain.model.pedidos.Frete
import com.poli.prevendasomie.domain.model.pedidos.InfoCadastro
import com.poli.prevendasomie.domain.model.pedidos.InformacoesAdicionais
import com.poli.prevendasomie.domain.model.pedidos.PedidoVendaProduto
import com.poli.prevendasomie.domain.model.pedidos.TotalPedido
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
class OrdersDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: ErpDatabase
    private lateinit var ordersDao: OrdersDao

    @Before
    fun setup() {

        database = Room
            .inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                ErpDatabase::class.java
            )
            .allowMainThreadQueries()
            .build()

        ordersDao = database.ordersDao()
    }
    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertProductTest() = runBlockingTest {

        val pedidos = listOf<PedidoVendaProduto> (
            PedidoVendaProduto(
                id = 100,
                cabecalho = Cabecalho(
                    bloqueado = "não",
                    codigoCenarioImpostos = "não",
                    codigoCliente = 1234,
                    codigoEmpresa = 123,
                    codigoParcela = "não",
                    codigoPedido = 1234,
                    codigoPedidoIntegracao = "não",
                    dataPrevisao = "não",
                    etapa = "não",
                    importadoApi = "não",
                    numeroPedido = "não",
                    origemPedido = "não",
                    qtdeParcelas = 2,
                    quantidadeItens = 2
                ),
                frete = Frete(),
                infoCadastro = InfoCadastro(),
                informacoesAdicionais = InformacoesAdicionais(),
                totalPedido = TotalPedido()
            )
        )

        ordersDao.persistOrderList(pedidos)

        val getOrders = ordersDao.getAllOrders()

        println(getOrders)

        assertThat(getOrders)
    }
}
