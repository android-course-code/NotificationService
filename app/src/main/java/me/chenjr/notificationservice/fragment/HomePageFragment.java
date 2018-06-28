package me.chenjr.notificationservice.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import me.chenjr.notificationservice.NotificationService;
import me.chenjr.notificationservice.R;
import me.chenjr.notificationservice.button.ServiceButton;

public class HomePageFragment extends Fragment {
    ServiceButton startServiceBtn ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        startServiceBtn = view.findViewById(R.id.frag_home_btn_record_service);
        startServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServiceButton btn = (ServiceButton) v;
                if (!btn.getServicesStatus()){
                getContext().startService(new Intent(getContext(), NotificationService.class));
                btn.updateStatus(true);}
                else {
                    getContext().stopService(new Intent(getContext(), NotificationService.class));
                    btn.updateStatus(false);
                }

            }
        });

        return view;

    }
}

