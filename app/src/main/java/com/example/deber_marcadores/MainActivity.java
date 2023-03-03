package com.example.deber_marcadores;


import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener
{
    //let service;
    GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        CameraUpdate camUpd1 = CameraUpdateFactory.newLatLngZoom(new LatLng(-1.0097359955229466, -79.46945600409167), 15);
        mMap.moveCamera(camUpd1);
        LatLng punto = new LatLng(-1.0097359955229466, -79.46945600409167);
        mMap.addMarker(new MarkerOptions().position(punto)
                .title("KFC - Paseo Shopping Quevedo").snippet("Restaurante de comida Rapida"));

        LatLng punto1 = new LatLng(-1.0261532990246718, -79.46195878713736);
        mMap.addMarker(new MarkerOptions().position(punto1)
                .title("Parrilladas Juan Diego").snippet("Cierra a las 23:00"));

        LatLng punto2 = new LatLng(-1.0297790801008668, -79.46848197004529);
        mMap.addMarker(new MarkerOptions().position(punto2)
                .title("Restaurant D Carlos").snippet("Pedidos desde el automóvil"));

        LatLng punto3 = new LatLng(-1.010161782441817, -79.46835798176097);
        mMap.addMarker(new MarkerOptions().position(punto3)
                .title("California Panadería y Pastelería").snippet("Transversal Central entre Jose Peralta y Patria Nueva C.C. Paseo Shopping de Quevedo, Quevedo"));

        LatLng punto4 = new LatLng(-1.0134642951989752, -79.46931229461099);
        mMap.addMarker(new MarkerOptions().position(punto4)
                .title("Lokos D' Asar\n").snippet("XGPJ+H7G, Quevedo"));

        LatLng punto5 = new LatLng(-1.0053491499892837, -79.46707947403729);
        mMap.addMarker(new MarkerOptions().position(punto5)
                .title("Restaurante La Española\n").snippet("Av. Quito, Quevedo"));

        LatLng punto6 = new LatLng(-1.008974761278689, -79.47598073000229);
        mMap.addMarker(new MarkerOptions().position(punto6)
                .title("La sazón d´ejota\n").snippet("Venus, Patria Nueva, Quevedo 400400"));


        mMap.setInfoWindowAdapter(new MainActivity2(getLayoutInflater()));


    }

    @Override
    public void onMapClick(LatLng latLng) {
        Projection proj = mMap.getProjection();
        Point coord = proj.toScreenLocation(latLng);
        Toast.makeText(MainActivity.this, "Click\n" + "Lat: " + latLng.latitude + "\n" + "Lng: " + latLng.longitude + "\n" + "X: " + coord.x + " - Y: " + coord.y, Toast.LENGTH_SHORT).show();
    }
}