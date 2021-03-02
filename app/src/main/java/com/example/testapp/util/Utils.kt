package com.example.testapp.util

import android.content.Context
import android.widget.Toast

object Utils {
    fun toast(context: Context, text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()

    }
}