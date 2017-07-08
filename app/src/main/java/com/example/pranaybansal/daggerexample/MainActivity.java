package com.example.pranaybansal.daggerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pranaybansal.daggerexample.model.GitPojo;
import com.example.pranaybansal.daggerexample.modules.ContextMdule;
import com.example.pranaybansal.daggerexample.network.ApiCalls;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.ivProfilePhoto) ImageView ivProfilePhoto;

    @BindView(R.id.txtUser) TextView txtUser;

    @Inject
    GitHubProfileImage profileImage;

    @Inject
    ApiCalls hitApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ActivityComponent component = DaggerActivityComponent.builder()
                .contextMdule(new ContextMdule(this))
                .build();

        component.injectMainActivity(this);

        hitApi.getUserDetails("pranay1494")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GitPojo>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull GitPojo gitPojo) {
                        txtUser.setText("login-ID: "+ gitPojo.getLogin());
                        profileImage.getProfileImage(gitPojo.getAvatar_url(),ivProfilePhoto);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
