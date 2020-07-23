package com.example.firstaid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.firstaid.model.*;
import com.example.firstaid.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Accident> listData;

    public MyAdapter(ArrayList<Accident> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvAcc.setText(listData.get(position).getmTitle());
        Glide.with(context).load(listData.get(position).getmImage()).into(holder.imgVAcc);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
    ImageView imgVAcc;
    TextView tvAcc;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        imgVAcc = itemView.findViewById(R.id.imgv);
        tvAcc = itemView.findViewById(R.id.tv_title);
    }
}
}
