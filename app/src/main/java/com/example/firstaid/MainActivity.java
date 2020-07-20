package com.example.firstaid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.GridLayout;

import com.example.firstaid.adapter.MyAdapter;
import com.example.firstaid.fragment.FrGuide;
import com.example.firstaid.model.Accident;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        AX();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        FrGuide frGuide = new FrGuide();
        transaction.add(R.id.frameLayout, frGuide);
        transaction.commit();
    }
    public void AX(){
        frameLayout = findViewById(R.id.frameLayout);
    }
    public void CreateData()
    {

    }


}