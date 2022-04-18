package com.tensorflow.lite.examples.classification.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tensorflow.lite.examples.classification.DataBase.Flower;
import com.tensorflow.lite.examples.classification.DataBase.FlowerInfo;
import com.tensorflow.lite.examples.classification.MyView.BaseFileDialog;

import org.tensorflow.lite.examples.classification.R;

import java.util.List;

public class MainAdapter extends  RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private final Context context;
    private  final List<Flower> data;

    public MainAdapter(Context context, List<Flower> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.flower_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Flower flower =data.get(position);
        holder.tv_name.setText(flower.getType());
        holder.imageView.setImageResource(flower.getId());
        holder.layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

               return false;
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout layout;
        ImageView imageView;
        TextView tv_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.show_card);
            imageView = itemView.findViewById(R.id.img_flower);
            tv_name = itemView.findViewById(R.id.flower_name);


        }
    }
}
