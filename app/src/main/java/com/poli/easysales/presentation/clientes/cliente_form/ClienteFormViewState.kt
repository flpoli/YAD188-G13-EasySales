package com.poli.easysales.presentation.clientes.cliente_form

import com.poli.easysales.core.UiText
import com.poli.easysales.domain.model.clientes.ClientesCadastro

sealed class ClienteFormViewState(

    open val inputEnabled: Boolean = true,
    open val cliente: ClientesCadastro

) {

    object Initial : ClienteFormViewState(
        cliente = ClientesCadastro()
    )

    data class Active(
        override val cliente: ClientesCadastro,
        val inputError: UiText? = null
    ) : ClienteFormViewState(cliente = cliente)

    data class Submitting(
        override val cliente: ClientesCadastro,
    ) : ClienteFormViewState(
        cliente = cliente,
        inputEnabled = false
    )

    data class SubmissionError(
        override val cliente: ClientesCadastro,
        val errorMessage: UiText

    ) : ClienteFormViewState(cliente = cliente)

    object Completed : ClienteFormViewState(

        cliente = ClientesCadastro(),
        inputEnabled = false

    )
}
