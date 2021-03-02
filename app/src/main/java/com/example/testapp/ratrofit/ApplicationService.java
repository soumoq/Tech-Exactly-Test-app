package com.example.testapp.ratrofit;


import com.example.testapp.model.application.Apps;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface ApplicationService {

    @FormUrlEncoded
    @POST("api/v1/apps/list")
    Call<Apps> applicationList(
            @Field("kid_id") String key_id
    );
}