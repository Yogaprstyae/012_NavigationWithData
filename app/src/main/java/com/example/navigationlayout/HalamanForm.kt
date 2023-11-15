package com.example.navigationlayout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanForm(
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    onBackButtonClicked : () -> Unit
){
    var nama by remember { mutableStateOf("") }
    var noTelp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Data Pelanggan")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = nama,
            onValueChange = {nama = it},
            label = { Text(text = "Nama") })
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = noTelp,
            onValueChange = {noTelp = it},
            label = { Text(text = "noTelp") })
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = alamat,
            onValueChange = {alamat = it},
            label = { Text(text = "Alamat") })
        Spacer(modifier = Modifier.padding(16.dp))
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween)
        {
            Button(
                modifier = Modifier.padding(10.dp),
                onClick = {
                    onBackButtonClicked
                }
            ) {
                Text(text = stringResource(R.string.btn_back),
                    fontSize = 16.sp
                )
            }
            Button(
                modifier = Modifier.padding(10.dp),
                onClick = { onSubmitButtonClicked }
            ) {
                Text(
                    text = stringResource(R.string.btn_submit),
                    fontSize = 16.sp
                )
            }
        }
    }
}