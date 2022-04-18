package com.tensorflow.lite.examples.classification.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tensorflow.lite.examples.classification.Adapter.ThirdAdapter;
import com.tensorflow.lite.examples.classification.Adapter.ThirdInfo;

import org.tensorflow.lite.examples.classification.R;

import java.util.ArrayList;


public class NotificationsFragment extends Fragment {
    private int[] imageId = {R.drawable.help, R.drawable.ic_shoucang};
    private String[] iconId = {"关于", "帮助"};
    private RecyclerView rvThird;
    private ArrayList<ThirdInfo> list;
    private ThirdAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        initView(view);
        initDta();
        return view;
    }
    private void initView(View view) {
        rvThird = view. findViewById(R.id.rv_third);
        list=new ArrayList<>();
        adapter=new ThirdAdapter(this.getContext(),list);
        rvThird.setAdapter(adapter);
        rvThird.setLayoutManager(new LinearLayoutManager(this.getContext()));

    }
    private void initDta(){
        for (int i=0;i<imageId.length;i++){
            list.add(new ThirdInfo(imageId[i],iconId[i]));

        }

    }
}