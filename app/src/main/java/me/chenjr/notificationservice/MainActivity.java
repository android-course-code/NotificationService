package me.chenjr.notificationservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showNotification(View view) {
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);

        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("WebView Loaded.")
                .setContentText("Notification from button callback. ")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(pi)
                //.setLights(Color.BLUE,500,100)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                //.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_foreground))
                .setAutoCancel(true)
                .build();

        EditText editText = findViewById(R.id.url_edittext);
        WebView webView = findViewById(R.id.main_web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        webView.loadUrl(editText.getText().toString());
        manager.notify(1,notification);


    }

    public void showNotificationService(View view) {

    }
}
