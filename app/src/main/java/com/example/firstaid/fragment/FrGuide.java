package com.example.firstaid.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstaid.R;
import com.example.firstaid.adapter.ListDataAdapter;
import com.example.firstaid.model.Accident;

import com.example.firstaid.model.Step;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class FrGuide extends Fragment  {
    public static final String NAME ="NAME";
    public static final String IMG ="IMG";
    public static final String STEPS ="STEPS";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private RecyclerView recyclerView;

    public ListDataAdapter listDataAdapter;
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
        listDataAdapter = new ListDataAdapter(listData, getActivity());
        db.collection("DB_ACC")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            // myAdapter.notifyDataSetChanged();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Accident accident = document.toObject(Accident.class);
                                accident.setKey(document.getId());
                                listData.add(accident);
                                Log.d("ahihi", document.getId() + " => " + document.getData());
                                Log.d("wtf", "trong for");
                            }
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                            recyclerView.setAdapter(listDataAdapter);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            Log.d("wtf", listData.size()+"");
                            Log.d("wtf", "trong if");
                        } else {
                            Log.d("so sad", "Error getting documents: ", task.getException());
                        }
                    }
                });

        Log.d("wtf", "ngoài");



        Log.d("sizeee", "size = "+ listData.size());
        return view;
    }





}
