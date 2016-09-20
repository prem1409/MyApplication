package com.example.ramesh.myapplication;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Ramesh on 9/6/2016.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);

    }
}
