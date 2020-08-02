package com.example.firstaid.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstaid.R;
import com.example.firstaid.adapter.MyAdapter;
import com.example.firstaid.model.Accident;

import com.example.firstaid.model.Step;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrGuide extends Fragment {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private RecyclerView recyclerView;

    public MyAdapter myAdapter;
    private ArrayList<Accident> listData;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_guide, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewAccs);

        listData = new ArrayList<>();

        ArrayList<Step> steps = new ArrayList<>();

        //create data ahihi
//        for(int i=11;i<= 20; i++){
//            Step step = new Step("Nội dung bước: "+ i, "https://i.imgur.com/pCis9E6.jpg");
//            steps.add(step);
//        }
//        Map<String , Object> DB = new HashMap<>();
//        for (int i=11;i<=20;i++){
//            DB.put("ACC_"+i, new Accident("Bất tỉnh", "https://i.imgur.com/pCis9E6.jpg",steps));
//            db.collection("DB_ACC").document("ACC_"+i).set(DB.get("ACC_"+i));
//        }


        db.collection("DB_ACC")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Accident accident = document.toObject(Accident.class);
                                listData.add(accident);
                                Log.d("ahihi", document.getId() + " => " + document.getData());
                                Log.d("sizeee", "size = "+ listData.size());
                            }
                        } else {
                            Log.d("so sad", "Error getting documents: ", task.getException());
                        }
                    }
                });


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        myAdapter = new MyAdapter(listData, getActivity());
        recyclerView.setAdapter(myAdapter);

        recyclerView.setLayoutManager(linearLayoutManager);
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
