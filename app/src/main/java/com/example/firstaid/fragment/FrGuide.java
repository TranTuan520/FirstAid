package com.example.firstaid.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstaid.R;
import com.example.firstaid.adapter.MyAdapter;
import com.example.firstaid.model.Accident;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FrGuide extends Fragment {
    private DatabaseReference mDatabase;

    private ImageView imageView;
    private RecyclerView recyclerView;

    private MyAdapter myAdapter;
    private ArrayList<Accident> listData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_guide, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewAccs);
        imageView = view.findViewById(R.id.imgv);

        createData();

        //get data
        mDatabase = FirebaseDatabase.getInstance().getReference();


//        mDatabase.child("AC").push().setValue(new Accident("https://i.imgur.com/GL8xOgy.jpg", "Bất tỉnh"));
//        mDatabase.child("AC").push().setValue(new Accident("https://i.imgur.com/zsu7taH.jpg", "Chảy máu"));
//        mDatabase.child("AC").push().setValue(new Accident("https://i.imgur.com/MpbxazA.jpg", "Bỏng"));
//        mDatabase.child("AC").push().setValue(new Accident("https://i.imgur.com/eqKdP9b.jpg", "Gãy Xương"));
//        mDatabase.child("AC").push().setValue(new Accident("https://i.imgur.com/dAFPuSD.jpg", "Đột quỵ"));
//        mDatabase.child("AC").push().setValue(new Accident("https://i.imgur.com/a9CURnz.jpg", "Nhồi máu cơ tim"));
//        mDatabase.child("AC").push().setValue(new Accident("https://i.imgur.com/H7ep4C7.jpg", "Điện giật"));
//        mDatabase.child("AC").push().setValue(new Accident("https://i.imgur.com/pCis9E6.jpg", "Đuối nước"));
//        mDatabase.child("AC").push().setValue(new Accident("https://i.imgur.com/Wug0ELn.jpg", "Hóc"));
//        mDatabase.child("AC").push().setValue(new Accident("https://i.imgur.com/UKD78fn.jpg", "Vết cắn, chích"));
//        mDatabase.child("AC").push().setValue(new Accident("https://i.imgur.com/iHUNp8x.jpg", "Nhiễm độc"));
//        mDatabase.child("AC").push().setValue(new Accident("https://i.imgur.com/1FIMRpF.jpg", "Gân, cơ bầm"));
//        ArrayList<Accident> list = new ArrayList<>();
//
//        list.add(new Accident("https://i.imgur.com/GL8xOgy.jpg", "Bất tỉnh"));
//        list.add(new Accident("https://i.imgur.com/zsu7taH.jpg", "Chảy máu"));
//        list.add(new Accident("https://i.imgur.com/MpbxazA.jpg", "Bỏng"));
//        list.add(new Accident("https://i.imgur.com/eqKdP9b.jpg", "Gãy Xương"));
//        list.add(new Accident("https://i.imgur.com/dAFPuSD.jpg", "Đột quỵ"));
//        list.add(new Accident("https://i.imgur.com/a9CURnz.jpg", "Nhồi máu cơ tim"));
//        list.add(new Accident("https://i.imgur.com/H7ep4C7.jpg", "Điện giật"));
//        list.add(new Accident("https://i.imgur.com/pCis9E6.jpg", "Đuối nước"));
//        list.add(new Accident("https://i.imgur.com/Wug0ELn.jpg", "Hóc"));
//        list.add(new Accident("https://i.imgur.com/UKD78fn.jpg", "Vết cắn, chích"));
//        list.add(new Accident("https://i.imgur.com/iHUNp8x.jpg", "Nhiễm độc"));
//        list.add(new Accident("https://i.imgur.com/1FIMRpF.jpg", "Gân, cơ bầm"));
//        mDatabase.child("AC2").push().setValue(list);
//        mDatabase.child("ahihi").push().setValue("2");
//        mDatabase.child("ahihi").push().setValue("3");
//        mDatabase.child("ahihi").push().setValue("4");

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            Toast.makeText(getActivity(), user.getUid().toString(), Toast.LENGTH_SHORT).show();
        } else {
            // No user is signed in
            Toast.makeText(getActivity(), "not login", Toast.LENGTH_SHORT).show();
        }

        mDatabase.child("AC").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Accident accident = snapshot.getValue(Accident.class);
                Log.d("fucking value: ", accident.getmImage());
                //Glide.with(getActivity()).load(accident.getmImage()).into(imageView);
                listData.add(accident);
                myAdapter.notifyDataSetChanged();
                //Toast.makeText(getActivity(), "ffffffffffffffffffffffffffffff", Toast.LENGTH_SHORT).show();
                // Toast.makeText(getActivity(), accident.getmTitle()+"", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //Log.d("zzzz", listData.size()+"");
        //Toast.makeText(getActivity(), listData.size()+"", Toast.LENGTH_SHORT).show();
        return view;
    }

    public void createData() {
//        DividerItemDecoration dividerHorizontal =
//                new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
//        recyclerView.addItemDecoration(dividerHorizontal);
//        DividerItemDecoration dividerVertical =
//                new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL);
//        recyclerView.addItemDecoration(dividerVertical);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        listData = new ArrayList<>();
        myAdapter = new MyAdapter(listData, getActivity());
        myAdapter.setHasStableIds(true);
        recyclerView.setAdapter(myAdapter);
    }
}
