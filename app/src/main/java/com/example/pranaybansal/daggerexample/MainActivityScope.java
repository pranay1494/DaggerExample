package com.example.pranaybansal.daggerexample;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Pranay Bansal on 7/9/2017.
 */


@Scope
@Retention(RetentionPolicy.CLASS)
public @interface MainActivityScope {
}
