package com.example.broadcastexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import static com.example.broadcastexample.MainActivity.ACTION_NOTIFY;


//STep 1, extend broadcast receiver and override onReceive method
public class DynamicReceivingComponent extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_USER_INITIALIZE)) {
            //respond to broadcast here
        } else if (intent.getAction().equals(ACTION_NOTIFY)) {
            //do whatever
        }
    }


}
