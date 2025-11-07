package com.example.inputnavigasi.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import com.example.inputnavigasi.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListPesertaScreen(
    onBeranda: () -> Unit,
    onFormulir: () -> Unit
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("List Daftar Peserta") }) }
    ) { pad ->
        Column(
            modifier = Modifier
                .padding(pad)
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // ====== Daftar Kartu (statis sesuai contoh gambar) ======
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    dimensionResource(id = R.dimen.padding_small)
                )
            ) {
                PesertaCard(
                    nama = "Pangeran Galang",
                    gender = "Laki-laki",
                    status = "Kawin",
                    alamat = "Sleman"
                )
                PesertaCard(
                    nama = "Queen LeeRuby",
                    gender = "Perempuan",
                    status = "Kawin",
                    alamat = "Bantul"
                )
            }

            // ====== Tombol bawah ======
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    dimensionResource(id = R.dimen.padding_small)
                )
            ) {
                OutlinedButton(
                    onClick = onBeranda,
                    modifier = Modifier.weight(1f)
                ) { Text("Beranda") }

                OutlinedButton(
                    onClick = onFormulir,
                    modifier = Modifier.weight(1f)
                ) { Text("Formulir") }
            }
        }
    }
}

@Composable
private fun PesertaCard(
    nama: String,
    gender: String,
    status: String,
    alamat: String
) {
    ElevatedCard {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(id = R.dimen.padding_small)
            )
        ) {
            RowField("NAMA LENGKAP", nama)
            RowField("JENIS KELAMIN", gender)
            RowField("STATUS PERKAWINAN", status)
            RowField("ALAMAT", alamat)
        }
    }
}

@Composable
private fun RowField(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label)
        Text(value, fontWeight = FontWeight.SemiBold)
    }
}
