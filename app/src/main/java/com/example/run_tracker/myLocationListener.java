package com.example.run_tracker;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class myLocationListener implements LocationListener {
Context context;
public static Location location;
/*public myLocationListener(Context context)
{
    this.context =  context;
}*/
    @Override
    public void onLocationChanged(@NonNull Location location) {
     String loc =   "Long:"+ (location != null ? location.getLongitude() : 0) +" "+"Lat:"+(location != null ? location.getLatitude() : 0);

       Toast.makeText(context,loc,Toast.LENGTH_LONG).show();
   this.location =location;
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Toast.makeText(context,"Gps status changed",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
        Toast.makeText(context,"Gps enabled",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        Toast.makeText(context,"Gps disabled",Toast.LENGTH_LONG).show();
    }
}
