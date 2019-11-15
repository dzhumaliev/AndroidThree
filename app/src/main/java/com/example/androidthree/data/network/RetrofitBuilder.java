package com.example.androidthree.data.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.androidthree.BuildConfig.BASE_URL_WEATHER;

public class RetrofitBuilder {

    public static RetrofitService instance;
    private static OkHttpClient client;


    public static RetrofitService getInstance() {
        if (instance == null) {
            instance = buildRetrofit();
        }
        return instance;
    }


    private static RetrofitService buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL_WEATHER)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(RetrofitService.class);

    }

    private static OkHttpClient getClient() {
        if (client == null) {
            client = okhttpBuilder();

        }
        return client;
    }

    private static OkHttpClient okhttpBuilder() {
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();

    }
}
