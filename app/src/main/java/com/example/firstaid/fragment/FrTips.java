package com.example.firstaid.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.firstaid.R;
import com.example.firstaid.model.Accident;

public class FrTips extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.fr_tips, container, false);
        WebView webView = view.findViewById(R.id.wv);
        webView.loadUrl("https://www.suckhoegiadinh.com.vn/");
        return view;
    }

}
