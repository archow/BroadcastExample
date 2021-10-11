package com.example.broadcastexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {
    public static final String ACTION_NOTIFY = "com.example.broadcastexample.ACTION_NOTIFY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sending intent
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(ACTION_NOTIFY);
        //an example of restricting your broadcast:
        broadcastIntent.setPackage("com.example.broadcastreceiverexample");

        //when sending a broadcast, you specify the permissions required
        //for opening that broadcast
        //
        //the permissions can be a systems permission, in which case you will
        //get the constant sting value
        //OR you can make your own
        //
        //system permissions example:
        sendOrderedBroadcast(broadcastIntent, "android.permission.ACCESS_NETWORK_STATE");

        //custom permissions example:
        sendOrderedBroadcast(broadcastIntent, "com.example.broadcastexample.mypermission");

        //can we supply a permission to a normal broadcast?
        sendBroadcast(broadcastIntent, "com.example.broadcastexample.mypermission");

        //To send local broadcast:
        LocalBroadcastManager.getInstance(this)
                .sendBroadcast(broadcastIntent);
    }
}