package com.tensorflow.lite.examples.classification.ui.home;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tensorflow.lite.examples.classification.Adapter.FlowerHobbyAdapter;
import com.tensorflow.lite.examples.classification.ClassifierActivity;
import com.tensorflow.lite.examples.classification.DataBase.FlowerHobby;

import org.litepal.LitePal;
import org.tensorflow.lite.examples.classification.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements View.OnClickListener {
    private FloatingActionButton floatingActionButton;
    private EditText etSearch;
    private Button btnSearch;
    private RecyclerView rvShow;
    String search_flower;
    List<FlowerHobby> flowerHobbies;
    FlowerHobbyAdapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void initView(View view) {
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(this);
flowerHobbies=new ArrayList<>();
adapter =new FlowerHobbyAdapter(getContext(),flowerHobbies);

        etSearch = (EditText) view.findViewById(R.id.et_search);
        btnSearch = (Button) view.findViewById(R.id.btn_search);
        rvShow = (RecyclerView) view.findViewById(R.id.rv_show);
        rvShow.setAdapter(adapter);
        rvShow.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_flower = etSearch.getText().toString().trim();
                if (check()) {
                    checkUsers();
                } else {
                    Toast.makeText(getContext(), "请检查您的输入后再进行查询", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.floatingActionButton:
                startActivity(new Intent(getContext(), ClassifierActivity.class));
                break;
        }
    }
    public void checkUsers() {
        List<FlowerHobby> users = LitePal.findAll(FlowerHobby.class);
        Log.i("TAG", "checkUsers:  ---------------"+users.size());

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getFlower_name().contains(search_flower)) {
                flowerHobbies.add(users.get(i));
                adapter= new FlowerHobbyAdapter(getContext(),flowerHobbies);
                rvShow.setAdapter(adapter);
                rvShow.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));

                Toast.makeText(getContext(),"查询成功",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getContext(),"该种花朵暂未收录，敬请期待",Toast.LENGTH_SHORT).show();

            }
        }


    }
    public boolean check(){
        if(search_flower.isEmpty()){
            return false;
        }else {
            return true;
        }

    }
}