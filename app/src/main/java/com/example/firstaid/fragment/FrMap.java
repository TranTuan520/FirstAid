package com.example.firstaid.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.firstaid.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

//public class FrMap extends Fragment implements OnMapReadyCallback {
//    private static final int REQUEST_CODE_GPS_PERMISSION = 100;
//    private GoogleMap mMap;
//    protected GeoDataClient mGeoDataClient;
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View  view = inflater.inflate(R.layout.fr_guide, container, false);
//        SupportMapFragment mapFragment = view.findViewById(R.id.map);
//        return view;
//    }
//    @RequiresApi(api = Build.VERSION_CODES.M)
//    @Override
//    public void onResume() {
//        super.onResume();
//        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
//                == PackageManager.PERMISSION_GRANTED) {
//            //TODO: Get current location
//            getCurrentLocation();
//        } else {
//            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
//                    REQUEST_CODE_GPS_PERMISSION);
//        }
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//    }
//
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//
//    }
//}
