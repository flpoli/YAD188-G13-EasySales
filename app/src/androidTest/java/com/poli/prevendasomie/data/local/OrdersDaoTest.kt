package com.poli.prevendasomie.data.local

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import com.poli.prevendasomie.data.local.dao.OrdersDao
import com.poli.prevendasomie.data.remote.responses.pedidos.CofinsPadrao
import com.poli.prevendasomie.data.remote.responses.pedidos.CofinsSt
import com.poli.prevendasomie.data.remote.responses.pedidos.Csll
import com.poli.prevendasomie.data.remote.responses.pedidos.Icms
import com.poli.prevendasomie.data.remote.responses.pedidos.IcmsIe
import com.poli.prevendasomie.data.remote.responses.pedidos.IcmsSn
import com.poli.prevendasomie.data.remote.responses.pedidos.IcmsSt
import com.poli.prevendasomie.data.remote.responses.pedidos.Ide
import com.poli.prevendasomie.data.remote.responses.pedidos.Inss
import com.poli.prevendasomie.data.remote.responses.pedidos.Ipi
import com.poli.prevendasomie.data.remote.responses.pedidos.Irrf
import com.poli.prevendasomie.data.remote.responses.pedidos.Iss
import com.poli.prevendasomie.data.remote.responses.pedidos.PisPadrao
import com.poli.prevendasomie.data.remote.responses.pedidos.PisSt
import com.poli.prevendasomie.data.util.GsonParser
import com.poli.prevendasomie.domain.model.pedidos.Cabecalho
import com.poli.prevendasomie.domain.model.pedidos.Det
import com.poli.prevendasomie.domain.model.pedidos.Frete
import com.poli.prevendasomie.domain.model.pedidos.Imposto
import com.poli.prevendasomie.domain.model.pedidos.InfAdic
import com.poli.prevendasomie.domain.model.pedidos.InfoCadastro
import com.poli.prevendasomie.domain.model.pedidos.InformacoesAdicionais
import com.poli.prevendasomie.domain.model.pedidos.ListaParcelas
import com.poli.prevendasomie.domain.model.pedidos.Observacao
import com.poli.prevendasomie.domain.model.pedidos.Observacoes
import com.poli.prevendasomie.domain.model.pedidos.OutrosDetalhes
import com.poli.prevendasomie.domain.model.pedidos.Parcela
import com.poli.prevendasomie.domain.model.pedidos.PedidoVendaProduto
import com.poli.prevendasomie.domain.model.pedidos.Produto
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
            .addTypeConverter(DatabaseConverter(GsonParser(Gson())))
            .build()

        ordersDao = database.ordersDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertOrderTest() = runBlockingTest {

        val mockPedidos = listOf<PedidoVendaProduto>(
            element = PedidoVendaProduto(
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
                    outrasDespesas = 10000.0,
                    pesoBruto = 15000.0,
                    pesoLiquido = 1000.0,
                    placa = "ABC123",
                    placaEstado = "SP",
                    previsaoEntrega = "10/10/2023",
                    quantidadeVolumes = 100,
                    registroTransportador = "não",
                    valorFrete = 150.0,
                    valorSeguro = 150.0,
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
                    outrosDetalhes = OutrosDetalhes(
                        cBairroOd = "BARRO",
                        cCEPOd = "02920040",
                        cCidadeOd = "São Paulo",
                        cCnpjCpfOd = "00.000.000/0000-00",
                        cEnderecoOd = "RUA XYZ",
                        cEstadoOd = "Sp",
                        cHoraSaidaOd = "10:10:10",
                        cInscrEstadualOd = "",
                        cNomeOd = "NOME",
                        cNumeroOd = "7545",
                        cTelefoneOd = "119999999",
                        dDataSaidaOd = "27/06/2023",
                    )
                ),
                totalPedido = TotalPedido(
                    baseCalculoIcms = 150.0,
                    baseCalculoSt = 150.0,
                    valorCofins = 70.0,
                    valorCsll = 0.0,
                    valorDeducoes = 0.0,
                    valorDescontos = 200.0,
                    valorIPI = 0.0,
                    valorIcms = 0.0,
                    valorInss = 0.0,
                    valorIr = 150.0,
                    valorIss = 0.0,
                    valorMercadorias = 15000.90,
                    valorPis = 150.0,
                    valorSt = 150.0,
                    valorTotalPedido = 20500.90

                ),
                det = listOf(
                    Det(
                        ide = Ide(
                            codigoItem = 321654513215,
                            codigoItemIntegracao = "21654231321",
                            idOrdemProducao = 216546321521,
                            simplesNacional = "NÃO"

                        ),
                        imposto = Imposto(
                            cofinsPadrao = CofinsPadrao(

                                aliqCofins = 0.0,
                                baseCofins = 0.0,
                                codSitTribCofins = "",
                                qtdeUnidTribCofins = 0,
                                tipoCalculoCofins = "",
                                valorCofins = 0.0,
                                valorUnidTribCofins = 0.0

                            ),
                            cofinsSt = CofinsSt(
                                aliqCofinsSt = 0.0,
                                baseCofinsSt = 0.0,
                                codSitTribCofinsSt = "",
                                margemCofinsSt = 0.0,
                                qtdeUnidTribCofinsSt = 0,
                                tipoCalculoCofinsSt = "",
                                valorCofinsSt = 0.0,
                                valorUnidTribCofinsSt = 0.0
                            ),
                            csll = Csll(
                                aliqCsll = 5.0,
                                valorCsll = 15.0
                            ),
                            icms = Icms(
                                aliqIcms = 0.0,
                                baseIcms = 0.0,
                                codSitTribIcms = "",
                                modalidadeIcms = "",
                                origemIcms = "",
                                percRedBaseIcms = 0.0,
                                valorIcms = 0.0
                            ),
                            icmsIe = IcmsIe(
                                aliqIcmsFCP = 0.0,
                                aliqInterestadual = 0.0,
                                aliqInternaUfDestino = 0.0,
                                aliqPartilhaIcms = 0.0,
                                baseIcmsUfDestino = 0.0,
                                valorFcpIcmsInter = 0.0,
                                valorIcmsUfDest = 0.0,
                                valorIcmsUfRemet = 0.0
                            ),
                            icmsSn = IcmsSn(
                                aliqIcmsSn = 0.0,
                                baseIcmsSn = 0.0,
                                codSitTribIcmsSn = "",
                                origemIcmsSn = "",
                                valorCreditoIcmsSn = 0.0,
                                valorIcmsSn = 0.0
                            ),
                            icmsSt = IcmsSt(
                                aliqIcmsOpprop = 0.0,
                                aliqIcmsSt = 0.0,
                                baseIcmsSt = 0.0,
                                cest = "",
                                codSitTribIcmsSt = "",
                                margemIcmsSt = 0.0,
                                modalidadeIcmsSt = "",
                                percRedBaseIcmsSt = 0.0,
                                valorIcmsSt = 0.0
                            ),
                            inss = Inss(
                                aliqInss = 0.0,
                                valorInss = 0.0,
                            ),
                            ipi = Ipi(
                                aliqIpi = 0.0,
                                baseIpi = 0.0,
                                codSitTribIpi = "",
                                enquadramentoIpi = "",
                                qtdeUnidTribIpi = 0,
                                tipoCalculoIpi = "",
                                valorIpi = 0.0,
                                valorUnidTribIpi = 0.0
                            ),
                            irrf = Irrf(
                                aliqIrrf = 0.0,
                                valorIrrf = 0.0
                            ),
                            iss = Iss(
                                aliqIss = 0.0,
                                baseIss = 0.0,
                                retemIss = "",
                                valorIss = 0.0
                            ),
                            pisPadrao = PisPadrao(
                                aliqPis = 0.0,
                                basePis = 0.0,
                                codSitTribPis = "",
                                qtdeUnidTribPis = 0,
                                tipoCalculoPis = "",
                                valorPis = 0.0,
                                valorUnidTribPis = 0.0
                            ),
                            pisSt = PisSt(
                                aliqPisSt = 0.0,
                                basePisSt = 0.0,
                                codSitTribPisSt = "",
                                margemPisSt = 0.0,
                                qtdeUnidTribPisSt = 0,
                                tipoCalculoPisSt = "",
                                valorPisSt = 0.0,
                                valorUnidTribPisSt = 0.0
                            )

                        ),
                        infAdic = InfAdic(
                            codigoCategoriaItem = "",
                            codigoCenarioImpostosItem = "",
                            codigoLocalEstoque = 54654564,
                            dadosAdicionaisItem = "",
                            itemPedidoCompra = 54654,
                            naoGerarFinanceiro = "",
                            naoMovimentarEstoque = "",
                            numeroPedidoCompra = "",
                            pesoBruto = 0.0,
                            pesoLiquido = 0.0,

                        ),
                        observacao = Observacao(
                            obsItem = "OBSERVAÇÃO ITEM"
                        ),
                        produto = Produto(
                            cfop = "",
                            cnpjFabricante = "",
                            codigo = "",
                            codigoProduto = 151651,
                            codigoTabelaPreco = 1551321321,
                            descricao = "",
                            ean = "",
                            indicadorEscala = "",
                            motivoIcmsDesonerado = "",
                            ncm = "",
                            percentualDesconto = 5.0,
                            quantidade = 1,
                            reservado = "",
                            tipoDesconto = "",
                            unidade = "",
                            valorDeducao = 0.0,
                            valorDesconto = 0.0,
                            valorIcmsDesonerado = 0.0,
                            valorMercadoria = 500.00,
                            valorTotal = 500.00,
                            valorUnitario = 500.00,

                        )

                    )
                ),
                listaParcelas = ListaParcelas(
                    parcela = listOf(
                        Parcela(
                            categoriaAdiantamento = "",
                            contaCorrenteAdiantamento = 12654,
                            dataVencimento = "",
                            meioPagamento = "",
                            naoGerarBoleto = "",
                            numeroParcela = 1,
                            parcelaAdiantamento = "",
                            percentual = 0.0,
                            quantidadeDias = 1,
                            tipoDocumento = "",
                            valor = 0.0
                        )
                    )
                ),
                observacoes = Observacoes(
                    obsVenda = "OBSERVAÇÃO DA VENDA"
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
