package com.android.dev.y_te.moduler.hospital;

import android.view.View;

import com.android.dev.y_te.R;
import com.android.dev.y_te.base.BaseFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by fcsdev on 10/1/16.
 */

public class HospitalFragment extends BaseFragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    @Override
    public int getLayoutID() {
        return R.layout.fragment_hospytal;
    }

    @Override
    public void onviewCreate(View view) {
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void init(View view) {

    }

    @Override
    public void action(View view) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
