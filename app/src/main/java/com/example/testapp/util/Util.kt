package com.example.testapp.util

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast

class Util {
    fun Context.toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}