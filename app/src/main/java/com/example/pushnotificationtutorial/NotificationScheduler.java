package com.example.pushnotificationtutorial;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class NotificationScheduler {
    public static void scheduleNotification(Context context, long delayMillis, String message) {
        Intent intent = new Intent(context, ScheduledNotificationReceiver.class);
        intent.putExtra("message", message);
        PendingIntent pendingIntent;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            pendingIntent = PendingIntent.getBroadcast(context, 0, intent,
                    PendingIntent.FLAG_IMMUTABLE);
        } else {
            pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        }

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        long futureTime = System.currentTimeMillis() + delayMillis;
        alarmManager.set(AlarmManager.RTC_WAKEUP, futureTime, pendingIntent);
    }
}
