package com.bi183.anandakusuma.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit retrofit;
    public static final String BASE_URL  = "https://collegeworkofadi2.000webhostapp.com/db_kampus/ws/api/";
    public static final String IMAGE_URL = "https://collegeworkofadi2.000webhostapp.com/db_kampus/ws/images/";

    public static Retrofit getRetrofitInstance(){
        if (retrofit==null){
            try {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            } catch (Exception er) {
                er.printStackTrace();
            }
        }
        return retrofit;
    }
}