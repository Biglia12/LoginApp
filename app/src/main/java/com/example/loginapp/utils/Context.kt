package com.example.loginapp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.Toast
import com.example.loginapp.utils.dialogs.showAlertDialog


fun Context.isNetworkAvailable(
    //showMessage: Boolean = false,
    title: String = "No hay conexion a internet",
    description: String = "No puede continuar"
): Boolean {
    var isConnected = false
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val nw = connectivityManager.activeNetwork
    val actNw = connectivityManager.getNetworkCapabilities(nw)

    if (actNw != null) {
        isConnected = when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
            else -> false
        }
    }

    if (!isConnected) {

        showAlertDialog(title, description)
    }

    return isConnected
}

fun Context.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}
