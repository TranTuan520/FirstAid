package com.example.firstaid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;


import com.example.firstaid.adapter.StepAdapter;
import com.example.firstaid.model.Step;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.firstaid.adapter.ListDataAdapter;
import com.example.firstaid.model.Accident;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class Detail extends AppCompatActivity {
    private ArrayList<Step> listStep;
    private ImageView imageView;
    private RecyclerView recyclerView;

    private String KEY ;
    private StepAdapter stepAdapter;


    private ViewPager viewPager;
    private ArrayList<Accident> listData;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        viewPager = findViewById(R.id.viewPager);


        Intent intent = this.getIntent();
        KEY  =  intent.getStringExtra("KEY");
        Log.d("KEY", "onCreate: "+KEY);

        DocumentReference docRef = db.collection("DB_ACC").document(KEY);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Accident accident = documentSnapshot.toObject(Accident.class);
                ArrayList<Step> steps = accident.getSteps();
                for(Step step : steps){
                    Log.d("Detail", "onSuccess: " + step.getmStep()+" : "+ step.getmImageLink());
                }
                stepAdapter = new StepAdapter(Detail.this, steps );
                viewPager.setAdapter(stepAdapter);

                //viewPager.setPadding(130, 0, 130, 0);
            }
        });




    }

}
