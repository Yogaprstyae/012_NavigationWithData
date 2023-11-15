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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanForm(
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    onBackButtonClicked : () -> Unit
){
    var nama by remember { mutableStateOf("") }
    var noTelp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var listData: MutableList<String> = mutableListOf(nama, noTelp, alamat)

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
        OutlinedTextField(
            value = noTelp,
            onValueChange = {noTelp = it},
            label = { Text(text = "noTelp") })
        OutlinedTextField(
            value = alamat,
            onValueChange = {alamat = it},
            label = { Text(text = "Alamat") })
        Spacer(modifier = Modifier.padding(16.dp))
        Row {
            Button(onClick = { onSubmitButtonClicked(listData) }) {
                Text(text = stringResource(id = R.string.btn_submit))
                Button(onClick = { onSubmitButtonClicked }) {
                    Text(text = stringResource(id = R.string.btn_back))
                }
            }
        }
    }
}