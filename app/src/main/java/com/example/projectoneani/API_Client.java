package com.example.projectoneani;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API_Client {

    public static String base_url = "https://pixabay.com/";

    public static Retrofit getClient(){

        HttpLoggingInterceptor htip = new HttpLoggingInterceptor();
        htip.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okhttpC =  new OkHttpClient.Builder()
                .addInterceptor(htip)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpC)
                .build();

        return retrofit;
    }

    public static API_Interface apiInterface(){

        return getClient().create(API_Interface.class);
    }

}
