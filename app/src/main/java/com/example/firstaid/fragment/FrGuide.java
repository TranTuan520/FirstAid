package com.example.firstaid.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstaid.R;
import com.example.firstaid.adapter.MyAdapter;
import com.example.firstaid.model.Accident;

import java.util.ArrayList;

public class FrGuide extends Fragment {
    private RecyclerView recyclerView;

    private MyAdapter myAdapter;
    private ArrayList<Accident> listData;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_guide, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewAccs);
        createData();
        return view;
    }
    public void createData(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(0);
        listData = new ArrayList<>();
        listData.add(new Accident( R.drawable.unconcious, "Bất tỉnh"));
        listData.add(new Accident( R.drawable.bleeding, "Chảy máu"));
        listData.add(new Accident( R.drawable.burn, "Bỏng"));
        listData.add(new Accident( R.drawable.bone, "Gãy xương"));
        listData.add(new Accident( R.drawable.stroke, "Đột quỵ"));
        listData.add(new Accident( R.drawable.heartattack, "Nhồi máu cơ tim"));
        listData.add(new Accident( R.drawable.electric, "Điện giật"));
        listData.add(new Accident( R.drawable.water, "Đuối nước"));
        listData.add(new Accident( R.drawable.choking, "Hóc"));
        listData.add(new Accident( R.drawable.snake, "Vết cắn,chích"));
        listData.add(new Accident( R.drawable.poisoned, "Nhiễm độc"));
        listData.add(new Accident( R.drawable.contusion, "Gân, cơ bầm"));
        DividerItemDecoration dividerHorizontal =
                new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerHorizontal);
        DividerItemDecoration dividerVertical =
                new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL);
        recyclerView.addItemDecoration(dividerVertical);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        gridLayoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(gridLayoutManager);

        myAdapter = new MyAdapter(listData);
        myAdapter.setHasStableIds(true);
        recyclerView.setAdapter(myAdapter);
    }
}
