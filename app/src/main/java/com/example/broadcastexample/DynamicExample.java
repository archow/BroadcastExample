package com.example.broadcastexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

//CReating a receiver dynamically


public class DynamicExample extends AppCompatActivity {

    BroadcastReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_example);

        //step 2: in your activity:
        //create the intent filters

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_USER_INITIALIZE);

        //step 3: initialize your broadcast receiver
        mReceiver = new DynamicReceivingComponent();

        //Step 4: call Context.registerReceiver( )
        //in this case your context is "this"
        this.registerReceiver(mReceiver, intentFilter);

    }

    //IF you only want your broadcast receiver to be alive when your activity is
    //visible, register your receiver in onResume

    //AND
    //unregister in onPause
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();

        //this is where you'll UNregister your receiver
        this.unregisterReceiver(mReceiver);
    }
}