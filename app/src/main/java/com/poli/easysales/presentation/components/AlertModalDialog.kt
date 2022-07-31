package com.poli.easysales.presentation.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties

@Composable
fun AlertModalDialog(

    onDismissCallBack: (Boolean) -> Unit,
    onConfirmAction: () -> Unit,
    state: MutableState<Boolean>,
    title: String,
    text: String
){

    if(state.value){
        AlertDialog(
            onDismissRequest = {
                state.value = false

                onDismissCallBack(state.value)

                               },
            confirmButton = { Button(onClick = {
                onConfirmAction()
                state.value = false
            }){Text(text = "Confirmar")} },
            dismissButton = {Button(onClick = { state.value = false }){Text(text = "Cancelar")} },

            title = { Text(text = title)},
            text = { Text(text = "Esta operação é irreverssível. Deseja continuar?")},
            properties = DialogProperties()
        )
    }




}

@Composable
@Preview(showBackground = true)
fun PreviewAlertDialog(){

    val state = remember {
        mutableStateOf(true)
    }

//    AlertModalDialog(state = state, title = "ALERTA", text = "LOREM IPSUN" )
}