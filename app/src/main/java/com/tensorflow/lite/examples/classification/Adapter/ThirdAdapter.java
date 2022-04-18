package com.tensorflow.lite.examples.classification.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.tensorflow.lite.examples.classification.HelpActivity;

import org.tensorflow.lite.examples.classification.R;

import java.util.List;


public class ThirdAdapter extends RecyclerView.Adapter<ThirdAdapter.ViewHolder> {
    private final Context context;
    private final List<ThirdInfo> data;

    public ThirdAdapter(Context context, List<ThirdInfo> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.third_item_layout,
                parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ThirdInfo thirdInfo=data.get(position);
        holder.imageId.setImageResource(thirdInfo.getImageId());
        holder.iconID.setText(thirdInfo.getIconId());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(view.getContext(), HelpActivity.class));
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageId;
        TextView iconID;
        LinearLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageId=itemView.findViewById(R.id.imageId);
            iconID=itemView.findViewById(R.id.iconId);
            layout=itemView.findViewById(R.id.third_layout);
        }
    }
}
