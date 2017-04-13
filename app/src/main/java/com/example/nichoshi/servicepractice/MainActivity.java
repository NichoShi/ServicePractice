package com.example.nichoshi.servicepractice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button startBtn;
    private Button stopBtn;
    private Button bindBtn;
    private Button unBindBtn;
    private Button binderStartBtn;
    private Button binderGetProgressBtn;
    private Button startIntentServiceBtn;
    private Button startLongRunningServiceBtn;
    private MyService.MyBinder myBinder;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (MyService.MyBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startBtn = (Button) findViewById(R.id.startServiceBtn);
        stopBtn = (Button) findViewById(R.id.stopServiceBtn);
        bindBtn = (Button) findViewById(R.id.bindServiceBtn);
        unBindBtn = (Button) findViewById(R.id.unBindServiceBtn);
        binderStartBtn = (Button) findViewById(R.id.binderStartBtn);
        binderGetProgressBtn = (Button) findViewById(R.id.binderGetProgressBtn);
        startIntentServiceBtn = (Button) findViewById(R.id.startIntentServiceBtn);
        startLongRunningServiceBtn = (Button) findViewById(R.id.startLongRunningServiceBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyService.class);
                startService(intent);
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyService.class);
                stopService(intent);
            }
        });

        bindBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyService.class);
                bindService(intent,serviceConnection,BIND_AUTO_CREATE);
            }
        });

        unBindBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(serviceConnection);
            }
        });

        binderStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBinder.start();
            }
        });

        binderGetProgressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBinder.getProgress();
            }
        });

        startIntentServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity","Thread is "+ Thread.currentThread().getId());
                Intent intent = new Intent(MainActivity.this,MyIntentService.class);
                startService(intent);
            }
        });

        startLongRunningServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LongRunningService.class);
                startService(intent);
            }
        });


    }
}
