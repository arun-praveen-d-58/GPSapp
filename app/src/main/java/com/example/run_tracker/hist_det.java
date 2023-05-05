package com.example.run_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.ArrayList;

public class hist_det extends AppCompatActivity {
    ArrayList<String> data;
    SupportMapFragment mapFragment;
    TextView avg_speed,total_dist,total_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hist_det);

        avg_speed = findViewById(R.id.avg_speed);
        total_dist = findViewById(R.id.total_dist);
        total_time =findViewById(R.id.total_time);

        mapFragment = new SupportMapFragment();
        //  ((SupportMapFragment) Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.frame_map))).getMapAsync(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_map_hist, mapFragment).commit();
        //mapFragment.getMapAsync((OnMapReadyCallback) this);

        Bundle b=  getIntent().getExtras();
        assert b != null;
        data = b.getStringArrayList("Data");

        assert data != null;
        setTitle(data.get(0));
        total_dist.setText(data.get(1));
        avg_speed.setText(data.get(2));
        total_time.setText(data.get(3));










    }




}