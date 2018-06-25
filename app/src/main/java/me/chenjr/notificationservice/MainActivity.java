package me.chenjr.notificationservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showNotification(View view) {
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("This title.")
                .setContentText("Hello Notification! ")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
//                .setLights(Color.BLUE,500,100)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                //.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_foreground))
                .setAutoCancel(true)
                .build();
        manager.notify(1,notification);

    }

    public void showNotificationService(View view) {
    }
}
