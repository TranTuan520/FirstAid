package com.example.firstaid.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.firstaid.Detail;
import com.example.firstaid.R;
import com.example.firstaid.model.Accident;
import com.example.firstaid.model.CustomFilter;

import java.util.ArrayList;

public class ListDataAdapter extends RecyclerView.Adapter<ListDataAdapter.ViewHolder> implements Filterable {

    private Context context;
    public ArrayList<Accident> listData;
    public ArrayList<Accident> filterList;
    private Intent intent ;
    CustomFilter customFilter;

    public ListDataAdapter(ArrayList<Accident> listData, Context context) {
        this.listData = listData;
        this.context = context;
        this.filterList = listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_item, parent, false);
        return new ViewHolder(view);
    }




    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvAcc.setText(listData.get(position).getmName());
        Glide.with(context).load(listData.get(position).getmImgLink()).into(holder.imgVAcc);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(context, Detail.class);
               intent.putExtra("KEY", listData.get(position).getKey());
               context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    @Override
    public Filter getFilter() {
        if (customFilter == null) {
            customFilter = new CustomFilter(filterList, this);
        }
        return customFilter;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgVAcc;
        TextView tvAcc;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgVAcc = itemView.findViewById(R.id.imgv);
            tvAcc = itemView.findViewById(R.id.tv_title);
            cardView = itemView.findViewById(R.id.cardViewAccident);
        }
    }

}
