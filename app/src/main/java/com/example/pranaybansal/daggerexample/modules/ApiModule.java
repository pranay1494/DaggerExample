package com.example.pranaybansal.daggerexample.modules;

import com.example.pranaybansal.daggerexample.MainActivityScope;
import com.example.pranaybansal.daggerexample.network.ApiCalls;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pranay Bansal on 7/9/2017.
 */

@Module
public class ApiModule {

    @Provides
    @MainActivityScope
    public ApiCalls callApi(Retrofit retrofit){
        return retrofit.create(ApiCalls.class);
    }

    @Provides
    @MainActivityScope
    public Retrofit retrofitClient(OkHttpClient client){
        return new Retrofit.Builder().baseUrl("https://api.github.com/users/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }
}
