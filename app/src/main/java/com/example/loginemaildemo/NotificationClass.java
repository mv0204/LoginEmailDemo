package com.example.loginemaildemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationClass extends AppCompatActivity {
    public static final String CHANNEL_ID = "pill Channel";
    public static final int NOTIFICATION_ID = 100;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_class);
        button=findViewById(R.id.button2);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.pill, null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeicon = bitmapDrawable.getBitmap();
        Notification notification;

        Notification.InboxStyle inboxStyle=new Notification.InboxStyle()
                .addLine("Don't forget to take your Pills")
                .addLine("Take a Pill and Chill");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeicon)
                    .setSmallIcon(R.drawable.small_icon)
                    .setContentText("GET YOUR PILLS NOW..")
                    .setStyle(inboxStyle)
                    .setChannelId(CHANNEL_ID)
                    .build();
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "pills", NotificationManager.IMPORTANCE_HIGH));
        } else {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeicon)
                    .setSmallIcon(R.drawable.small_icon)
                    .setContentText("GET YOUR PILLS NOW..")
                    .setStyle(inboxStyle)
                    .build();

        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                nm.notify(NOTIFICATION_ID, notification);

                startActivity(new Intent(getApplicationContext(),PillReminder.class));
            }
        });




    }
}