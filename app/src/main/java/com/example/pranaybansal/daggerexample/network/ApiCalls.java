package com.example.pranaybansal.daggerexample.network;

import com.example.pranaybansal.daggerexample.model.GitPojo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Pranay Bansal on 6/29/2017.
 */

public interface ApiCalls {
    @GET("{user}")
    Observable<GitPojo> getUserDetails(@Path("user") String user);
}
