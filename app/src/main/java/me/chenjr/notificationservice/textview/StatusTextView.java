package me.chenjr.notificationservice.textview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class StatusTextView extends TextView {
    boolean servicesStatus = false;


    public void updateStatus(boolean status){
        if (status){
            this.setText("✔️");
            setTextColor(Color.GREEN);
            Toast.makeText(getContext(),"Running",Toast.LENGTH_SHORT).show();
        }else {
            this.setText("❌");
            setTextColor(Color.RED);
            Toast.makeText(getContext(),"Not Running",Toast.LENGTH_SHORT).show();
        }
    }

    public StatusTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        updateStatus(servicesStatus);
    }

    public StatusTextView(Context context) {
        super(context);
        updateStatus(servicesStatus);

    }
}
