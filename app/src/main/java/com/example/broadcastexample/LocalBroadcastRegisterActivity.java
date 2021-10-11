package com.example.broadcastexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import static com.example.broadcastexample.MainActivity.ACTION_NOTIFY;

public class LocalBroadcastRegisterActivity extends AppCompatActivity {
    DynamicReceivingComponent mDynamicReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_broadcast_register);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_NOTIFY);

        mDynamicReceiver = new DynamicReceivingComponent();

        //Now I can register my local reciever
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(mDynamicReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mDynamicReceiver != null) {
            LocalBroadcastManager.getInstance(this)
                    .unregisterReceiver(mDynamicReceiver);
        }
    }
}