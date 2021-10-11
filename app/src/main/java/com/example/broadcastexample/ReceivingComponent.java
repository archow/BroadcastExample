package com.example.broadcastexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class ReceivingComponent extends BroadcastReceiver {
    private static final String ACTION_SHOW_TOAST = "com.example.myproject.ACTION_NOTIFY";

    @Override
    public void onReceive(Context context, Intent intent) {
        //you'll check for which type of intent you're responding to
        if (intent.getAction().equals(ACTION_SHOW_TOAST)) {
            //example
            //show toast message

        }

        //make sure the intent is NOT null
        //perform some kind of action
    }
}
