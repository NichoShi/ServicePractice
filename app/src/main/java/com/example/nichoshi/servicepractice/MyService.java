package com.example.nichoshi.servicepractice;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by NichoShi on 2017/4/13.
 */

public class MyService extends Service {
    private MyBinder myBinder = new MyBinder();
    @Override
    public void onCreate() {
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);
        Notification notification = new Notification.Builder(this)
                                        .setSmallIcon(R.mipmap.ic_launcher)
                                        .setContentIntent(pendingIntent)
                                        .setContentTitle("Title")
                                        .setContentText("Text")
                                        .setWhen(System.currentTimeMillis()).build();
        startForeground(1,notification);
        Log.d("MyService","onCreate()");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService","onStartCommand()");

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    @Override
    public void onDestroy() {
        Log.d("MyService","onDestroy()");
        super.onDestroy();
    }

    class MyBinder extends Binder{
        public void start(){
            Log.d("MyBinder","start()");
        }

        public void getProgress(){
            Log.d("MyBinder","getProgress()");
        }
    }


}
