package com.tensorflow.lite.examples.classification.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tensorflow.lite.examples.classification.DataBase.FlowerHobby;

import org.litepal.LitePal;
import org.tensorflow.lite.examples.classification.R;

import java.util.List;

public class FlowerHobbyAdapter extends RecyclerView.Adapter<FlowerHobbyAdapter.ViewHolder> {
    Context context;
    List<FlowerHobby> data;

    public FlowerHobbyAdapter(Context context, List<FlowerHobby> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.flower_hobby_item, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FlowerHobby flowerHobby =data.get(position);
        holder.name.setText(String.valueOf(flowerHobby.getFlower_name()));
        holder.time.setText(String.valueOf(flowerHobby.getFlower_Time()));
        holder.layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog alert = null;
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());;
                alert = builder
                        .setTitle(flowerHobby.getFlower_name())
                        .setMessage(flowerHobby.getFlower_is_wet())
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).create();
                alert.show();
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,time;
        LinearLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.flower_hobby_name);
            time = itemView.findViewById(R.id.flower_hobby_time);
            layout=itemView.findViewById(R.id.flower_hobby_layout);

        }
    }
}
