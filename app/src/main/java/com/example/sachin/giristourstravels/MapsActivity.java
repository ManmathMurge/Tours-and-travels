package com.example.sachin.giristourstravels;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Marker marker,marker_new;
    MarkerOptions a;
    double latitude, longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        LatLng center;
        center = mMap.getCameraPosition().target;
        marker = mMap.addMarker(new MarkerOptions().position(center).title("Center Position"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center ));

        mMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
            @Override
            public void onCameraMove() {
                //marker.remove();
                latitude = mMap.getCameraPosition().target.latitude;
                longitude = mMap.getCameraPosition().target.longitude;
                LatLng latLng = new LatLng(latitude,longitude);
                marker.setPosition(latLng);

                //marker = mMap.addMarker(new MarkerOptions().position(latLng).title("Center Position"));

            }

        });

        //LatLng sydney = new LatLng(-34, 151);
//        marker = mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
//            @Override
//            public void onMapClick(LatLng position) {
//                Toast.makeText(getApplicationContext(), position.latitude + " : " + position.longitude, Toast.LENGTH_SHORT).show();
//                a = new MarkerOptions().position(position);
//                if (marker == null) {
//                    marker = mMap.addMarker(a);
//                    marker.setPosition(position);
//                }
//
//                else {
//                    marker.remove();
//                    marker = mMap.addMarker(a);
//                    marker.setPosition(position);
//                }
//            }
//        });
    }
}
