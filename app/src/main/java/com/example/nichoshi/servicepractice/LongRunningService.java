package com.example.nichoshi.servicepractice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Date;

/**
 * Created by NichoShi on 2017/4/13.
 */

public class LongRunningService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("LongRunningService","executed at "+ new Date().toString());
            }
        }).run();

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent i = new Intent(this,AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,i,PendingIntent.FLAG_CANCEL_CURRENT);
        long triggerAtTime = SystemClock.elapsedRealtime() + 10000;
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,pendingIntent);
        return super.onStartCommand(intent, flags, startId);
    }
}
