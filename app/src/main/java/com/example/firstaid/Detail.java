package com.example.firstaid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.widget.ImageView;


import com.example.firstaid.model.Step;

import androidx.recyclerview.widget.RecyclerView;

import com.example.firstaid.R;
import com.example.firstaid.adapter.MyAdapter;
import com.example.firstaid.model.Accident;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class Detail extends AppCompatActivity {
    private ArrayList<Step> listStep;
    private ImageView imageView;
    private RecyclerView recyclerView;
    private DatabaseReference DB;

    private String KEY ;

    private MyAdapter myAdapter;
    private ArrayList<Accident> listData;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference cities = db.collection("DB_ACC");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = this.getIntent();
        KEY  =  intent.getStringExtra("KEY");
        Log.d("KEY", "onCreate: "+KEY);
        DocumentReference docRef = db.collection("DB_ACC").document(KEY);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Accident accident = documentSnapshot.toObject(Accident.class);
                Log.d("Detail", "onSuccess: " + accident.getmName());
            }
        });




    }

}
