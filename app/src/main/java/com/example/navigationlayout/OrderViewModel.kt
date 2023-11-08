package com.example.navigationlayout

import android.icu.text.NumberFormat
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.example.navigationlayout.data.OrderUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

private const val HARGA_PER_CUP = 3000

class OrderViewModel : ViewModel() {
    private  val _stateUI = MutableStateFlow(OrderUIState())
    val stateUI: StateFlow<OrderUIState> = _stateUI.asStateFlow()

    @RequiresApi(Build.VERSION_CODES.N)
    fun setJumlah(jmlSusu:Int){
        _stateUI.update { stateSaatIni -> stateSaatIni.copy(jumlah = jmlSusu,
            harga = hitungHarga(jumlah = jmlSusu))}
    }

    fun setRasa(rasaPilihan: String) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy( rasa = rasaPilihan)
        }
    }

    fun resetOrder() {
        _stateUI.value = OrderUIState()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun hitungHarga(
        jumlah: Int = _stateUI.value.jumlah,
    ): String {
        val kalkulasiHarga = jumlah * HARGA_PER_CUP
        return NumberFormat.getNumberInstance().format(kalkulasiHarga)
    }
}