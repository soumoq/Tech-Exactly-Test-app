package com.example.testapp.ratrofit

import com.example.testapp.model.application.Apps
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AppService {
    @FormUrlEncoded
    @POST("api/v1/apps/list")
    fun applicationList(@Field("kid_id") key_id: Int): Call<Apps?>?
}