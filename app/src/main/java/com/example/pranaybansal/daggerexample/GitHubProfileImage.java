package com.example.pranaybansal.daggerexample;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

/**
 * Created by Pranay Bansal on 7/9/2017.
 */

public class GitHubProfileImage {
    Context context;
    @Inject
    public GitHubProfileImage(Context context) {
        this.context = context;
    }

    public void getProfileImage(String url, ImageView imageView){
        Glide.with(context).load(url).into(imageView);
    }
}
