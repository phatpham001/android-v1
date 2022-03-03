package com.example.facerecognition.API;

import com.example.facerecognition.Models.AccountModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiAccount {
//    https://hitu-face-recognition.herokuapp.com/
    Gson gson = new GsonBuilder()
        .setDateFormat("yyyy-MM-dd HH:mm:ss")
        .create();

    ApiAccount apiAccount = new Retrofit.Builder()
        .baseUrl("https://hitu-face-recognition.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(ApiAccount.class);

    @GET("account")
    Call<AccountModel> accountModelCall(@Query("username") String username,
                                        @Query("password") String password);

    @GET("account")
    Call<List<AccountModel>> accountModelCall1(@Query("username") String username,
                                               @Query("password") String password);


}
