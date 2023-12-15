package com.example.loginapp.utils.dialogs

import android.app.AlertDialog
import android.content.Context

fun Context.showAlertDialog(
    title: String,
    message: String,
    positiveButtonLabel: String = "OK",
    negativeButtonLabel: String? = null,
    positiveAction: (() -> Unit)? = null,
    negativeAction: (() -> Unit)? = null
): AlertDialog {
    val builder = AlertDialog.Builder(this)
    builder.setTitle(title)
        .setMessage(message)
        .setPositiveButton(positiveButtonLabel) { _, _ ->
            positiveAction?.invoke()
        }

    if (negativeButtonLabel != null) {
        builder.setNegativeButton(negativeButtonLabel) { _, _ ->
            negativeAction?.invoke()
        }
    }

    val dialog = builder.create()
    dialog.show()
    return dialog
}