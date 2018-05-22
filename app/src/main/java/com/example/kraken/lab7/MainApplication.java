package com.example.kraken.lab7;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

/**
 * Created by kraken on 5/22/18.
 */

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        BroadcastReceiver br1 = new MyBroadcastReceiver();
        br1.onReceive(this, new Intent());

        BroadcastReceiver br2 = new MyBroadcastReceiver2();
        br2.onReceive(this, new Intent());
    }
}
