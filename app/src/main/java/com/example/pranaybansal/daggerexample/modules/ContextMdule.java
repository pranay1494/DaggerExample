package com.example.pranaybansal.daggerexample.modules;

import android.app.Activity;
import android.content.Context;

import com.example.pranaybansal.daggerexample.MainActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pranay Bansal on 7/9/2017.
 */
@Module
public class ContextMdule {
    Context context;

    public ContextMdule(Activity activity) {
        context = activity;
    }

    @Provides
    @MainActivityScope
    public Context activityContext() {
        return context;
    }
}
