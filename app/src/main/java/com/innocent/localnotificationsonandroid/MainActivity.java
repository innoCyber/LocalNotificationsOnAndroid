package com.innocent.localnotificationsonandroid;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),1,intent,0);
        Notification notification = new Notification.Builder(getApplicationContext())
                .setContentTitle("You have new messages")
                .setContentText("This is the message")
                .setContentIntent(pendingIntent)
                .addAction(android.R.drawable.sym_action_chat, "Read",pendingIntent)
                .setSmallIcon(android.R.drawable.ic_dialog_email)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1,notification);
    }
}
