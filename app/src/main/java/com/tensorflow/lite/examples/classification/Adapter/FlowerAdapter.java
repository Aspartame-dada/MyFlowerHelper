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

import com.tensorflow.lite.examples.classification.DataBase.FlowerInfo;
import com.tensorflow.lite.examples.classification.MyView.BaseFileDialog;

import org.tensorflow.lite.examples.classification.R;

import java.util.List;

public class FlowerAdapter extends  RecyclerView.Adapter<FlowerAdapter.ViewHolder> {
    private final Context context;
    private  final List<FlowerInfo> data;
    public FlowerAdapter(Context context, List<FlowerInfo> data) {
        this.context = context;
        this.data = data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FlowerAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.flower_item_layput,parent,false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        FlowerInfo flowerInfo =data.get(position);
        holder.tv_name.setText("花朵类型："+flowerInfo.getType());
        holder.tv_date.setText(flowerInfo.getData());
        holder.imageView.setImageResource(flowerInfo.getObjectId());
        holder.layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                BaseFileDialog.newInstance().createBaseDialog(context,position,flowerInfo);

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
        TextView tv_date;
        TextView tv_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout=itemView.findViewById(R.id.flower_layout);
            tv_date = itemView.findViewById(R.id.flower_date);
            tv_name=itemView.findViewById(R.id.flower_name);
            imageView=itemView.findViewById(R.id.imageView2);


        }
    }
}
