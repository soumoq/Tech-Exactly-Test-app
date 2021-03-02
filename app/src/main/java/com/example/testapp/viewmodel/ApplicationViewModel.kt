package com.example.testapp.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.AuthFailureError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.testapp.model.application.AppLists
import com.example.testapp.model.application.Apps
import com.example.testapp.ratrofit.ApplicationService
import com.example.testapp.ratrofit.RestApiServiceBuilder
import com.example.testapp.util.Utils
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class ApplicationViewModel : ViewModel() {
    var appList = MutableLiveData<List<AppLists>>()

    /*fun getAppList(context: Context, key_id: String) {
        val appService = RestApiServiceBuilder.buildService(ApplicationService::class.java)
        val response: Call<Apps> = appService.applicationList(key_id)
        response.enqueue(object : Callback<Apps> {
            override fun onResponse(call: Call<Apps>, response: Response<Apps>) {
                if (response.isSuccessful) {
                    Utils.toast(context, response.body()?.message!!)
                    appList.value = response.body()
                } else {
                    Utils.toast(context, "Something went wrong!")
                }
            }

            override fun onFailure(call: Call<Apps>, t: Throwable) {
                Utils.toast(context, "Something went wrong!!")

            }
        })
    }*/

    fun createOrder(context: Context) {
        val URL = "http://34.206.75.222/mobile-app/api/v1/apps/list"
        val requestQueue = Volley.newRequestQueue(context)
        val stringRequest: StringRequest = object : StringRequest(
            Method.POST, URL,
            com.android.volley.Response.Listener { response ->
                var json1: JSONObject? = null
                try {
                    json1 = JSONObject(response)
                    val success = json1.getBoolean("success")
                    if (success) {

                        val appArray = ArrayList<AppLists>()
                        val data = json1.getJSONObject("data")
                        val app_list = data.getJSONArray("app_list")
                        for (i in 0 until app_list.length()) {
                            val appListObj = app_list.getJSONObject(i)
                            appArray.add(
                                AppLists(
                                    appListObj.getString("app_id"),
                                    appListObj.getString("app_name"),
                                    appListObj.getString("app_icon"),
                                    appListObj.getString("app_package_name"),
                                    appListObj.getString("status")
                                )
                            )
                            //Log.e("VOLLY", appListObj.getString("app_id"))
                        }
                        appList.value = appArray


                    } else {
                        toast(context, "false")
                    }
                } catch (e: JSONException) {
                    toast(context, "Some thing went wrong: " + e.message)
                }
            },
            com.android.volley.Response.ErrorListener { error -> //toast("Some thing went wrong: " + error.getMessage());
                toast(context, "Some thing went wrong: " + error.message)
            }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params["kid_id"] = "378"
                return params
            }
        }
        requestQueue.cache.clear()
        requestQueue.add(stringRequest)
    }

    private fun toast(context: Context, text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }

}