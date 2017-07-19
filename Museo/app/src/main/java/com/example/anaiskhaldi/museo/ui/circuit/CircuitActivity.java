package com.example.anaiskhaldi.museo.ui.circuit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.anaiskhaldi.museo.R;
import com.example.anaiskhaldi.museo.models.circuit.CircuitGet;
import com.example.anaiskhaldi.museo.models.detail.DetailGet;
import com.example.anaiskhaldi.museo.ui.detail.DetailActivity;
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
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.gson.Gson;

import java.util.ArrayList;

public class CircuitActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = "Circuit Get";
    private GoogleMap mapCircuit;
    private TextView textViewStartAddress;
    private TextView textViewEndAddress;
    private TextView textViewDistance;
    private TextView textViewDuration;
    private LinearLayout linearLayoutInstruction;
    private ImageView backCircuit;


    private final ArrayList<LatLng> lstLatLng = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circuit);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapCircuit);
        mapFragment.getMapAsync(this);

        textViewStartAddress = (TextView) findViewById(R.id.textViewStartAddress);
        textViewEndAddress = (TextView) findViewById(R.id.textViewEndAddress);
        textViewDistance = (TextView) findViewById(R.id.textViewDistance);
        textViewDuration = (TextView) findViewById(R.id.textViewDuration);
        linearLayoutInstruction = (LinearLayout) findViewById(R.id.linearLayoutInstruction);
        backCircuit = (ImageView) findViewById(R.id.backCircuit);

        getCircuit();

        // Retour en arrière
        backCircuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(CircuitActivity.this, DetailActivity.class));
        finish();
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

        mapCircuit = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng paris = new LatLng(48.856614, 2.3522219);
        //mMap.addMarker(new MarkerOptions().position(paris).title("Marker in Paris"));
        //mapDetail.moveCamera(CameraUpdateFactory.newLatLngZoom(paris, 12));


    }

    private void getCircuit() {

        if (Network.isNetworkAvailable(CircuitActivity.this)) {

            // Instantiate the RequestQueue.
            RequestQueue queue = Volley.newRequestQueue(CircuitActivity.this);
            String url = String.format(Constant.URL_GET_CIRCUIT, Preference.getSearchLocationCoordinate(CircuitActivity.this), Preference.getMuseumPlaceId(CircuitActivity.this)); //l'url du web service

            Log.d(TAG, "url :" + url);

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) { // 200

                            Gson gson = new Gson(); //une instance d'un objet Gson (permet de décoder le fichier JSON qui est renvoyé par le serveur).
                            CircuitGet circuitGet = gson.fromJson(response, CircuitGet.class); //nous lançons le décodage (La lecture du fichier JSON renvoyé par le web service )

                            if(circuitGet.status.equals("OK")) {


                            for(int i = 0; i < circuitGet.routes.size(); i++){

                                for(int j = 0; j < circuitGet.routes.get(i).legs.size(); j++){

                                    String startAddress = circuitGet.routes.get(i).legs.get(j).start_address;
                                    String[] start_address_array = startAddress.split(",");
                                    String start_address = start_address_array[0];
                                    textViewStartAddress.setText(start_address);

                                    String endAddress = circuitGet.routes.get(i).legs.get(j).end_address;
                                    String[] end_address_array = endAddress.split(",");
                                    String end_address = end_address_array[0];
                                    textViewEndAddress.setText(end_address);

                                    String distance = circuitGet.routes.get(i).legs.get(j).distance.text;
                                    textViewDistance.setText(distance);

                                    String duration = circuitGet.routes.get(i).legs.get(j).duration.text;
                                    textViewDuration.setText(duration);


                                    // Add Marker for start and end on the map
                                    Float start_lat = circuitGet.routes.get(i).legs.get(j).start_location.lat;
                                    Float start_lng = circuitGet.routes.get(i).legs.get(j).start_location.lng;
                                    Float end_lat = circuitGet.routes.get(i).legs.get(j).end_location.lat;
                                    Float end_lng = circuitGet.routes.get(i).legs.get(j).end_location.lng;


                                    addMarker(start_lat, start_lng, end_lat, end_lng);

                                    // Recuperation des steps
                                    PolylineOptions options = new PolylineOptions().width(10).color(Color.rgb(0, 66, 131)).geodesic(true);

                                    Float first_lat = circuitGet.routes.get(i).legs.get(j).steps.get(0).start_location.lat;
                                    Float first_lng = circuitGet.routes.get(i).legs.get(j).steps.get(0).start_location.lng;

                                    LatLng first_points = new LatLng(first_lat, first_lng);

                                    options.add(first_points);

                                    for(int k = 1; k < circuitGet.routes.get(i).legs.get(j).steps.size(); k++){

                                        Float lat = circuitGet.routes.get(i).legs.get(j).steps.get(k).end_location.lat;
                                        Float lng = circuitGet.routes.get(i).legs.get(j).steps.get(k).end_location.lng;

                                        LatLng point = new LatLng(lat,lng);
                                        options.add(point);

                                        String instruction = circuitGet.routes.get(i).legs.get(j).steps.get(k).html_instructions;
                                        String instructionNoFirstDiv = instruction.replace("<div style=\"font-size:0.9em\">", "<br/><span>> ");
                                        String instructionNoEndDiv = instructionNoFirstDiv.replace("</div>", "</span>");

                                        TextView instructionHTML = new TextView(CircuitActivity.this);
                                        instructionHTML.setText(k + ". " + Html.fromHtml(instructionNoEndDiv));
                                        instructionHTML.setTextColor(Color.BLACK);
                                        instructionHTML.setTextSize(16);
                                        linearLayoutInstruction.setBackgroundResource(R.drawable.border);
                                        linearLayoutInstruction.addView(instructionHTML);


                                    }

                                    mapCircuit.addPolyline(options);

                                }


                            }



                            } else {

                                FastDialog.showDialog(CircuitActivity.this, FastDialog.SIMPLE_DIALOG, "erreur");

                            }

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            FastDialog.showDialog(CircuitActivity.this, FastDialog.SIMPLE_DIALOG, "Probleme ");
                        }
                    }
            );

            // Add the request to the RequestQueue.
            queue.add(stringRequest);
        } else {
            FastDialog.showDialog(CircuitActivity.this, FastDialog.SIMPLE_DIALOG, "Vous devez être connecté");
        }

    }


    public void addMarker(Float start_lat, Float start_lng, Float end_lat, Float end_lng){

        // Change and Resize the marker
        int height = 131;
        int width = 100;
        BitmapDrawable bitmapdraw = (BitmapDrawable)getResources().getDrawable(R.drawable.splashscreen_marker_red);
        Bitmap b = bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);

        BitmapDrawable bitmapdrawblue = (BitmapDrawable)getResources().getDrawable(R.drawable.map_marker_blue);
        Bitmap bb = bitmapdrawblue.getBitmap();
        Bitmap smallMarkerBlue = Bitmap.createScaledBitmap(bb, width, height, false);


        // Add a marker
        LatLng start_location = new LatLng(start_lat,start_lng);
        mapCircuit.addMarker(new MarkerOptions().position(start_location)
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarkerBlue)));
        LatLng end_location = new LatLng(end_lat,end_lng);
        mapCircuit.addMarker(new MarkerOptions().position(end_location)
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));

        mapCircuit.moveCamera(CameraUpdateFactory.newLatLngZoom(end_location, 16));



    }


}

