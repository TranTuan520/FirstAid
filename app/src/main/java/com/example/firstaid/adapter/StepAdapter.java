package com.example.firstaid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.firstaid.R;
import com.example.firstaid.model.Step;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;


import java.util.ArrayList;

public class StepAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<Step> listData;
    private LayoutInflater layoutInflater;

    public StepAdapter(Context context, ArrayList<Step> listData) {
        this.context = context;
        this.listData = listData;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cardview_step, container, false);
        ImageView imageView = view.findViewById(R.id.imgStep);
        TextView textView = view.findViewById(R.id.tvStep);
        Step step = listData.get(position);

        Glide.with(context).load(step.getmImageLink()).into(imageView);
        textView.setText(step.getmStep());
        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    public static class ViewHolder {

    }
}
