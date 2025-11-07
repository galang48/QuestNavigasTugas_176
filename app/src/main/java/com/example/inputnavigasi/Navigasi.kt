package com.example.inputnavigasi

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.inputnavigasi.view.FormIsian
import com.example.inputnavigasi.view.ListPesertaScreen
import com.example.inputnavigasi.view.WelcomeScreen

enum class Navigasi { Welcome, List, Formulir }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataApp() {
    val nav = rememberNavController()

    Scaffold { pad ->
        NavHost(
            navController = nav,
            startDestination = Navigasi.Welcome.name,
            modifier = Modifier.padding(pad)
        ) {
            composable(Navigasi.Welcome.name) {
                WelcomeScreen(onMasuk = { nav.navigate(Navigasi.List.name) })
            }
            composable(Navigasi.List.name) {
                ListPesertaScreen(
                    onBeranda = { nav.navigate(Navigasi.Welcome.name) },
                    onFormulir = { nav.navigate(Navigasi.Formulir.name) }
                )
            }
            composable(Navigasi.Formulir.name) {
                FormIsian(
                    onSubmit = { _, _, _, _ -> /* data local saja, tidak perlu VM */ },
                    onSelesaiDialog = {
                        // setelah OK di dialog, kembali ke List
                        nav.popBackStack()
                        nav.navigate(Navigasi.List.name)
                    },
                    onBeranda = { nav.navigate(Navigasi.Welcome.name) }
                )
            }
        }
    }
}
