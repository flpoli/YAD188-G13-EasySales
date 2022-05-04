package com.poli.prevendasomie.data.local

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.poli.prevendasomie.data.local.dao.OrdersDao
import com.poli.prevendasomie.data.remote.responses.pedidos.OutrosDetalhesDto
import com.poli.prevendasomie.domain.model.pedidos.Cabecalho
import com.poli.prevendasomie.domain.model.pedidos.Frete
import com.poli.prevendasomie.domain.model.pedidos.InfoCadastro
import com.poli.prevendasomie.domain.model.pedidos.InformacoesAdicionais
import com.poli.prevendasomie.domain.model.pedidos.OutrosDetalhes
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
    fun insertOrderTest() = runBlockingTest {

        val mockPedidos = listOf<PedidoVendaProduto> (
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
                frete = Frete(
                    codigoRastreio = "123456",
                    codigoTipoEntrega = 1,
                    codigoTransportadora = 1,
                    especieVolumes = "CAIXA",
                    marcaVolumes = "CAIXA",
                    modalidade = "Caminhao",
                    numeracaoVolumes = "CX123",
                    numeroLacre = "LACRE123",
                    outrasDespesas = 10000,
                    pesoBruto = 15000,
                    pesoLiquido = 1000,
                    placa = "ABC123",
                    placaEstado = "SP",
                    previsaoEntrega = "10/10/2023",
                    quantidadeVolumes = 100,
                    registroTransportador = "não",
                    valorFrete = 150,
                    valorSeguro = 150,
                    veiculoProprio = "não"
                ),
                infoCadastro = InfoCadastro(
                    autorizado = "AUTORIZADO",
                    cImpAPI = "SIM",
                    cancelado = "Não",
                    dAlt = "02/05/2022",
                    dCan = "",
                    dFat = "",
                    dInc = "02/05/2022",
                    denegado = "não",
                    devolvido = "não",
                    devolvidoParcial = "não",
                    faturado = "não",
                    hAlt = "NÃO SE APLICA",
                    hCan = "NÃO SE APLICA",
                    hFat = "NÃO SE APLICA",
                    hInc = "NÃO SE APLICA",
                    uAlt = "NÃO SE APLICA",
                    uCan = "NÃO SE APLICA",
                    uFat = "NÃO SE APLICA",
                    uInc = "NÃO SE APLICA"
                ),
                informacoesAdicionais = InformacoesAdicionais(
                    codProj = 1,
                    codVend = 100,
                    codigoCategoria = "1.1.1.20",
                    codigoContaCorrente = 2132158,
                    consumidorFinal = "não",
                    contato = "POLI",
                    dadosAdicionaisNf = "HOJE NÃO",
                    enviarEmail = "S",
                    numeroContrato = "CONTRATO123",
                    numeroPedidoCliente = "XPED123",
//                    outrosDetalhes = OutrosDetalhes(
//                        cBairroOd = "BARRO",
//                        cCEPOd = "02920040",
//                        cCidadeOd = "São Paulo",
//                        cCnpjCpfOd = "00.000.000/0000-00",
//                        cEnderecoOd = "RUA XYZ",
//                        cEstadoOd = "Sp",
//                        cHoraSaidaOd = "10:10:10",
//                        cInscrEstadualOd = "",
//                        cNomeOd = "NOME",
//                        cNumeroOd = "7545",
//                        cTelefoneOd = "119999999",
//                        dDataSaidaOd = "27/06/2023",
//                    )
                ),
                totalPedido = TotalPedido(
                    baseCalculoIcms = 150,
                    baseCalculoSt = 150,
                    valorCofins = 70,
                    valorCsll = 0,
                    valorDeducoes = 0,
                    valorDescontos = 200,
                    valorIPI = 0.0,
                    valorIcms = 0,
                    valorInss = 0,
                    valorIr = 150,
                    valorIss = 0,
                    valorMercadorias = 15000.90,
                    valorPis = 150,
                    valorSt = 150,
                    valorTotalPedido = 20500.90

                )
            )
        )
        Log.d("MOCKPEDIDO?", "$mockPedidos")
        ordersDao.persistOrderList(mockPedidos)

        val getOrders = ordersDao.selectOrderById(100)

        Log.d("SELECT ORDER", "$getOrders")

        assertThat(getOrders == mockPedidos[0]).isTrue()
    }
}
