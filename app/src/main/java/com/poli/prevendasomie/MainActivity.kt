package com.poli.prevendasomie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.ui.theme.PreVendasOmieTheme

class MainActivity : ComponentActivity() {

    private val service = OmieAPI.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreVendasOmieTheme {

                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}

