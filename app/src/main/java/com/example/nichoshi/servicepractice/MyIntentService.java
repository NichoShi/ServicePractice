package com.example.nichoshi.servicepractice;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by NichoShi on 2017/4/13.
 */

public class MyIntentService extends IntentService {

    public MyIntentService(){
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        Log.d("MyIntentService","onCreate()");
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("MyIntentService","onHandleIntent()"+"  Thread is " + Thread.currentThread().getId());
    }

    @Override
    public void onDestroy() {
        Log.d("MyIntentService","onDestroy()");
        super.onDestroy();
    }
}
