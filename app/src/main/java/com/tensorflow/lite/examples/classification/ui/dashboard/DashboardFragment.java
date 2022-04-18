package com.tensorflow.lite.examples.classification.ui.dashboard;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tensorflow.lite.examples.classification.Adapter.FlowerAdapter;
import com.tensorflow.lite.examples.classification.DataBase.Constants;
import com.tensorflow.lite.examples.classification.DataBase.FlowerInfo;
import com.tensorflow.lite.examples.classification.DataBase.MySQLiteHelper;

import org.litepal.LitePal;
import org.tensorflow.lite.examples.classification.R;

import java.util.ArrayList;
import java.util.List;


public class DashboardFragment extends Fragment {

    private RecyclerView tvSecond;
    private List<FlowerInfo> mlist;
    private FlowerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        tvSecond = (RecyclerView) view.findViewById(R.id.tv_second);
        mlist=LitePal.findAll(FlowerInfo.class);
        adapter=new FlowerAdapter(this.getContext(),mlist);
        tvSecond.setAdapter(adapter);
        tvSecond.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }

    private void initData(){
        mlist=LitePal.findAll(FlowerInfo.class);

        adapter.notifyDataSetChanged();
    }


}