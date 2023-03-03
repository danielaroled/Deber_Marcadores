package com.example.deber_marcadores;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class MainActivity2 implements GoogleMap.InfoWindowAdapter {
    LayoutInflater inflater=null;
    MainActivity2(LayoutInflater inflater){
        this.inflater=inflater;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View infoWindows=inflater.inflate(R.layout.fastfood, null);
        TextView title = (TextView) infoWindows.findViewById(R.id.textView);
        TextView description = (TextView) infoWindows.findViewById(R.id.textView2);
        title.setText(marker.getTitle());
        description.setText(marker.getSnippet());
        return (infoWindows);
    }
}
