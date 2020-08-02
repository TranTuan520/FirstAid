package com.example.firstaid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.firstaid.fragment.FrGuide;
import com.example.firstaid.fragment.FrMap;
import com.example.firstaid.fragment.FrTips;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityHome extends AppCompatActivity {
    private FrameLayout frameLayout;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home);
        frameLayout = findViewById(R.id.frameLayout);

        FragmentManager manager  = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        FrGuide frGuide = new FrGuide();
        transaction.add(R.id.frameLayout, frGuide);
        transaction.commit();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_guide:
                    fragment = new FrGuide();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_maps:
                    fragment = new FrMap();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_tips:
                    fragment = new FrTips();
                    loadFragment(fragment);
                    return true;
                default:
                    Toast.makeText(ActivityHome.this, "holy shit", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    };
    public  void loadFragment(Fragment fragment) {
        // load fragment
        androidx.fragment.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    //private BottomNavigationView.OnNavigationItemReselectedListener

    @Override
    protected void onResume() {

        super.onResume();

    }
}