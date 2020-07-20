package com.example.firstaid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstaid.R;
import com.example.firstaid.model.Accident;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Accident> listData;

    public MyAdapter( ArrayList<Accident> listData) {
        this.listData = listData;
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
        holder.imgVAcc.setImageResource(listData.get(position).getmImage());
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
