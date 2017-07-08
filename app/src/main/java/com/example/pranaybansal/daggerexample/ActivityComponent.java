package com.example.pranaybansal.daggerexample;

import com.example.pranaybansal.daggerexample.modules.ApiModule;
import com.example.pranaybansal.daggerexample.modules.ContextMdule;
import com.example.pranaybansal.daggerexample.modules.ImageLoaderModule;
import com.example.pranaybansal.daggerexample.modules.NetworkModules;

import dagger.Component;
import dagger.Module;

/**
 * Created by Pranay Bansal on 7/9/2017.
 */

@Component(modules = {ApiModule.class,NetworkModules.class, ContextMdule.class, ImageLoaderModule.class})
@MainActivityScope
public interface ActivityComponent {
    void injectMainActivity(MainActivity mainActivity);
}
