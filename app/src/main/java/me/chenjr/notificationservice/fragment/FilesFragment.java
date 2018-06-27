package me.chenjr.notificationservice.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import me.chenjr.notificationservice.FileItem;
import me.chenjr.notificationservice.FileItemAdapter;
import me.chenjr.notificationservice.R;

public class FilesFragment extends Fragment{
    List<FileItem> fileItemList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_files,container,false);
        for (int i = 0;i<10;i++){
            fileItemList.add(new FileItem("Record-file-"+i,R.mipmap.ic_sound_file));
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.frag_files_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        FileItemAdapter fileItemAdapter = new FileItemAdapter(fileItemList);
        recyclerView.setAdapter(fileItemAdapter);

        return view;

    }
}
