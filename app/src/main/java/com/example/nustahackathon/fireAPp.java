package com.example.nustahackathon;

import android.app.Application;

import com.firebase.client.Firebase;

public class fireAPp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
