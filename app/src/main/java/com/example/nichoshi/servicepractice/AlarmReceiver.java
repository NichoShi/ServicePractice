package com.example.nichoshi.servicepractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by NichoShi on 2017/4/13.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context,LongRunningService.class);
        context.startService(intent1);

    }
}
