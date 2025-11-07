package com.example.inputnavigasi.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.inputnavigasi.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilData(
    nama: String,
    gender: String,
    alamat: String,
    onBackBtnClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = stringResource(id = R.string.tampil)) })
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .padding(isiRuang)
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    dimensionResource(id = R.dimen.padding_small)
                )
            ) {
                Field(label = stringResource(R.string.nama_lengkap), value = nama)
                HorizontalDivider(thickness = dimensionResource(id = R.dimen.thickness_divider))
                Field(label = stringResource(R.string.jenis_kelamin), value = gender)
                HorizontalDivider(thickness = dimensionResource(id = R.dimen.thickness_divider))
                Field(label = stringResource(R.string.alamat), value = alamat)
                HorizontalDivider(thickness = dimensionResource(id = R.dimen.thickness_divider))
            }

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onBackBtnClick
            ) {
                Text(text = stringResource(id = R.string.back))
            }
        }
    }
}

@Composable
private fun Field(label: String, value: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = label, fontSize = 16.sp)
        Text(text = value.ifBlank { "-" }, fontWeight = FontWeight.Bold, fontSize = 22.sp)
    }
}
