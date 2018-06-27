package me.chenjr.notificationservice.button;


import android.content.Context;
import android.support.v7.widget.AppCompatButton;

public class ServiceButton extends AppCompatButton {
    public ServiceButton(Context context) {
        super(context);
        boolean servicesStatus = false;
        if (servicesStatus){
            this.setText("Running");
            this.setTextColor(0x00ff00);
        }else {
            this.setText("Not Running");
            this.setTextColor(0xff0000);
        }

    }

}
