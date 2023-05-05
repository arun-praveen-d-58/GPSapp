package com.example.run_tracker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment{

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


   View view = inflater.inflate(R.layout.fragment_maps, container, false);
/*
   SupportMapFragment supportMapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.My_Map);
   supportMapFragment.getMapAsync(new OnMapReadyCallback() {
       @Override
       public void onMapReady(@NonNull final GoogleMap googleMap) {

           googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL); // changing map type
          googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
              @Override
              public void onMapClick(@NonNull LatLng latLng) {
                  MarkerOptions markerOptions = new MarkerOptions();
                  markerOptions.position(latLng);
              //  markerOptions.title(latLng.latitude +"--"+latLng.longitude);
                 googleMap.clear();

                  googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,17));
                  googleMap.addMarker(markerOptions);

              }
          });
       }
   });



 */
        return view;
    }


   }