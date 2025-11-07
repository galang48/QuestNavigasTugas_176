package com.example.inputnavigasi.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.inputnavigasi.R
import androidx.compose.ui.Alignment
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Button

@Composable
fun WelcomeScreen(onMasuk: () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    "Selamat Datang",
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = .6f)
                )
                Spacer(Modifier.height(dimensionResource(id = R.dimen.padding_small)))
                Image(
                    painter = painterResource(R.drawable.ruby),
                    contentDescription = "CARD-LST",
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Fit
                )
            }
            Button(
                onClick = onMasuk,
                modifier = Modifier
                    .fillMaxWidth()
            ) { Text("Masuk") }
            }
        }
    }


