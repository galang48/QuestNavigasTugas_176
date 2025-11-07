package com.example.inputnavigasi.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.inputnavigasi.R
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(
    onSubmit: (String, String, String, String) -> Unit,
    onSelesaiDialog: () -> Unit,
    onBeranda: () -> Unit
) {
    var nama by rememberSaveable { mutableStateOf("") }
    var gender by rememberSaveable { mutableStateOf("") }
    var status by rememberSaveable { mutableStateOf("") }
    var alamat by rememberSaveable { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    val valid = nama.isNotBlank() && gender.isNotBlank() && status.isNotBlank() && alamat.isNotBlank()

    Scaffold(topBar = { TopAppBar(title = { Text("Formulir Pendaftaran") }) }) { pad ->
        Column(
            modifier = Modifier
                .padding(pad)
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    dimensionResource(id = R.dimen.padding_small)
                )
            ) {
                OutlinedTextField(
                    value = nama, onValueChange = { nama = it },
                    label = { Text("NAMA LENGKAP") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Text("JENIS KELAMIN")
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    Radio("Laki-laki", gender == "Laki-laki") { gender = "Laki-laki" }
                    Radio("Perempuan", gender == "Perempuan") { gender = "Perempuan" }
                }

                Text("STATUS PERKAWINAN")
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    Radio("Jejaka", status == "Jejaka") { status = "Jejaka" }
                    Radio("Lajang", status == "Lajang") { status = "Lajang" }
                    Radio("Duda", status == "Duda") { status = "Duda" }
                }

                OutlinedTextField(
                    value = alamat, onValueChange = { alamat = it },
                    label = { Text("ALAMAT") },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    dimensionResource(id = R.dimen.padding_small)
                )
            ) {
                OutlinedButton(
                    onClick = onBeranda,
                    modifier = Modifier.weight(1f)
                ) { Text("Beranda") }

                Button(
                    onClick = {
                        onSubmit(nama, gender, status, alamat)
                        showDialog = true
                    },
                    enabled = valid,
                    modifier = Modifier.weight(1f)
                ) { Text("Submit") }
            }
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = {},
            confirmButton = {
                TextButton(onClick = {
                    showDialog = false
                    onSelesaiDialog()
                }) { Text("OK") }
            },
            title = { Text("Data Berhasil Disimpan") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    DialogRow("Nama", nama)
                    DialogRow("Jenis Kelamin", gender)
                    DialogRow("Status", status)
                    DialogRow("Alamat", alamat)
                }
            }
        )
    }
}

@Composable
private fun DialogRow(k: String, v: String) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(k)
        Text(v, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun Radio(label: String, selected: Boolean, onSelect: () -> Unit) {
    Row {
        RadioButton(selected = selected, onClick = onSelect)
        Spacer(Modifier.width(4.dp))
        Text(label, modifier = Modifier.padding(top = 10.dp))
    }
}
