package com.example.proyecto_nota1;

import android.content.Intent;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


import androidx.appcompat.app.AppCompatActivity;


import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;



public class Estadio extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadio);


        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));

        MapView mapView = findViewById(R.id.mapView);
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);

        //Coordenadas Estadio Nacional
        double estadionacionalLatitude = -33.46451796175257;
        double estadionacionalLongitude = -70.61072102023995;

        //Coordenadas de Estadio Catolica
        double catolicaLatitude = -33.395908970353304;
        double catolicaLongitude = -70.50055043171632;

        //Coordenadas de Estadio Colo-Colo
        double colocoloLatitude = -33.5064909215994;
        double colocoloLongitude = -70.60596687116399;

        //Crear objetos GeoPoint para los marcadores
        GeoPoint nacionalPoint = new GeoPoint(estadionacionalLatitude, estadionacionalLongitude);
        GeoPoint catolicaPoint = new GeoPoint(catolicaLatitude, catolicaLongitude);
        GeoPoint colocoloPoint = new GeoPoint(colocoloLatitude,colocoloLongitude);

        //Crear marcadores con títulos y descripciones
        Marker nacionalMarker = new Marker(mapView);
        nacionalMarker.setPosition(nacionalPoint);
        nacionalMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        nacionalMarker.setTitle("Estadio Nacional");
        nacionalMarker.setSnippet("Estadio de la Seleccion");


        Marker colocoloMarker = new Marker(mapView);
        colocoloMarker.setPosition(colocoloPoint);
        colocoloMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        colocoloMarker.setTitle("Monumental");
        colocoloMarker.setSnippet("Estadio de Colo-Colo");

        Marker catolicaMarker = new Marker(mapView);
        catolicaMarker.setPosition(catolicaPoint);
        catolicaMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        catolicaMarker.setTitle("San carlos de apoquindo");
        catolicaMarker.setSnippet("Estadio de la universidad Catolica");

        //Agregar marcadores al mapa
        mapView.getOverlays().add(nacionalMarker);
        mapView.getOverlays().add(catolicaMarker);
        mapView.getOverlays().add(colocoloMarker);

        IMapController mapController = mapView.getController();
        mapController.setCenter(catolicaPoint);
        mapController.setZoom(17);

    }


}




