
package com.example.testapp.dialog;
import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.example.testapp.R


class MyProgressDialog (context: Context?) : AlertDialog(context) {
    override fun show() {
        super.show()
        setContentView(R.layout.dialog_progress)
    }

    init {
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}