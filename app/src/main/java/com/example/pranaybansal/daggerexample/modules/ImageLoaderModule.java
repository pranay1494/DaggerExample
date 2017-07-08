package com.example.pranaybansal.daggerexample.modules;

import android.content.Context;

import com.example.pranaybansal.daggerexample.GitHubProfileImage;
import com.example.pranaybansal.daggerexample.MainActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pranay Bansal on 7/9/2017.
 */

@Module
public class ImageLoaderModule {
    @Provides
    @MainActivityScope
    public GitHubProfileImage provideImageLoader(Context context){
        return new GitHubProfileImage(context);
    }
}
