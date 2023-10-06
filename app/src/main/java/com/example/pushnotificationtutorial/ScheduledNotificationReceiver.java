package com.example.pushnotificationtutorial;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;

public class ScheduledNotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String message = extras.getString("message");

            // Create an FCM RemoteMessage
            RemoteMessage.Builder builder = new RemoteMessage.Builder("your-sender-id@gcm.googleapis.com");
            builder.addData("title", "Scheduled Notification");
            builder.addData("body", message);

            // Send the FCM message
            FirebaseMessaging.getInstance().send(builder.build());
        }
    }
}
