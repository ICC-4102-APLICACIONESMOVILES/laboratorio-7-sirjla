package com.example.kraken.lab7;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by kraken on 5/22/18.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
            Intent intent2 = new Intent(context, MyBroadcastReceiver2.class);
            intent2.setAction("ALARM");
            alarmIntent = PendingIntent.getBroadcast(context, 0, intent2, 0);

            alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + AlarmManager.INTERVAL_HALF_HOUR/360,
                    AlarmManager.INTERVAL_HALF_HOUR/360, alarmIntent);

            Toast.makeText(context, "The Alarm has been set", Toast.LENGTH_LONG).show();
        }
    }
}