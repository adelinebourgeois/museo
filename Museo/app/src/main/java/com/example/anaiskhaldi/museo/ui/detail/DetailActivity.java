package com.example.anaiskhaldi.museo.ui.detail;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.anaiskhaldi.museo.R;
import com.example.anaiskhaldi.museo.models.detail.DetailGet;
import com.example.anaiskhaldi.museo.models.museum.DataGet;
import com.example.anaiskhaldi.museo.models.museum.MuseumGetGeometryData;
import com.example.anaiskhaldi.museo.ui.search.SearchLocationActivity;
import com.example.anaiskhaldi.museo.utils.Constant;
import com.example.anaiskhaldi.museo.utils.FastDialog;
import com.example.anaiskhaldi.museo.utils.Network;
import com.example.anaiskhaldi.museo.utils.Preference;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = "Detail";
    private GoogleMap mapDetail;
    private TextView textViewMuseumName;
    private TextView textViewAddress;
    private TextView textViewOpeningHours;
    private LinearLayout linearLayoutRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapDetail);
        mapFragment.getMapAsync(this);

        getMuseumDetail();

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mapDetail = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng paris = new LatLng(48.856614, 2.3522219);
        //mMap.addMarker(new MarkerOptions().position(paris).title("Marker in Paris"));
        //mapDetail.moveCamera(CameraUpdateFactory.newLatLngZoom(paris, 12));


    }

    public void getMuseumDetail() {

        textViewMuseumName = (TextView) findViewById(R.id.textViewMuseumName);
        textViewAddress = (TextView) findViewById(R.id.textViewAddress);
        textViewOpeningHours = (TextView) findViewById(R.id.textViewOpeningHours);

        linearLayoutRating = (LinearLayout) findViewById(R.id.linearLayoutRating);


        if (Network.isNetworkAvailable(DetailActivity.this)) {

            // Instantiate the RequestQueue.
            RequestQueue queue = Volley.newRequestQueue(DetailActivity.this);
            String url = String.format(Constant.URL_GET_MUSEUM_DETAIL, Preference.getMuseumPlaceId(DetailActivity.this)); //l'url du web service

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) { // 200

                            Gson gson = new Gson(); //une instance d'un objet Gson (permet de décoder le fichier JSON qui est renvoyé par le serveur).
                            DetailGet detailGet = gson.fromJson(response, DetailGet.class); //nous lançons le décodage (La lecture du fichier JSON renvoyé par le web service )

                            if(detailGet.status.equals("OK")) {

                                // Set text for museum name
                                textViewMuseumName.setText(detailGet.result.name);

                                // Set coordinates for marker on the map

                                addMarker(detailGet.result.geometry.location.lat, detailGet.result.geometry.location.lng);

                                // Set text for museum address
                                String formattedAdress = detailGet.result.formatted_address;
                                String address = formattedAdress.replace(", ", "\r\n");
                                textViewAddress.setText(address);

                                // Set text for museum opening hours
                                String openingMonday = detailGet.result.opening_hours.weekday_text[0];
                                String openingTuesday = detailGet.result.opening_hours.weekday_text[1];
                                String openingWednesday = detailGet.result.opening_hours.weekday_text[2];
                                String openingThursday = detailGet.result.opening_hours.weekday_text[3];
                                String openingFriday = detailGet.result.opening_hours.weekday_text[4];
                                String openingSaturday = detailGet.result.opening_hours.weekday_text[5];
                                String openingSunday = detailGet.result.opening_hours.weekday_text[6];

                                String openingDays = openingMonday + "\r\n" +
                                        openingTuesday + "\r\n" +
                                        openingWednesday + "\r\n" +
                                        openingThursday + "\r\n" +
                                        openingFriday + "\r\n" +
                                        openingSaturday + "\r\n" +
                                        openingSunday + "\r\n";
                                textViewOpeningHours.setText(openingDays);


                                // Rating
                                Float rating = detailGet.result.rating;

                                //linearLayoutRating

                                for(int i = 1; i < rating; i++){
                                    ImageView image = new ImageView(DetailActivity.this);
                                    image.setBackgroundResource(R.drawable.star_red);
                                    linearLayoutRating.addView(image);
                                    image.getLayoutParams().height = 100;
                                    image.getLayoutParams().width = 100;
                                }


                            } else {

                                FastDialog.showDialog(DetailActivity.this, FastDialog.SIMPLE_DIALOG, detailGet.error_message);

                            }

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            String message = new String(error.networkResponse.data);

                            FastDialog.showDialog(DetailActivity.this, FastDialog.SIMPLE_DIALOG, "Probleme "+message);
                        }
                    }
            );

            // Add the request to the RequestQueue.
            queue.add(stringRequest);
        } else {
            FastDialog.showDialog(DetailActivity.this, FastDialog.SIMPLE_DIALOG, "Vous devez être connecté");
        }


    }

    public void addMarker(Float lat, Float lng){

        // Change and Resize the marker
        int height = 131;
        int width = 100;
        BitmapDrawable bitmapdraw = (BitmapDrawable)getResources().getDrawable(R.drawable.splashscreen_marker_red);
        Bitmap b = bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);

        // Add a marker
        LatLng location = new LatLng(lat,lng);
        mapDetail.addMarker(new MarkerOptions().position(location)
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
        mapDetail.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 17));

    }


}
