package com.example.anaiskhaldi.museo.ui.location;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.anaiskhaldi.museo.R;
import com.example.anaiskhaldi.museo.models.DataGet;
import com.example.anaiskhaldi.museo.utils.Constant;
import com.example.anaiskhaldi.museo.utils.FastDialog;
import com.example.anaiskhaldi.museo.utils.Network;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import static com.example.anaiskhaldi.museo.R.*;

public class SearchLocationActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = "dataGetMap";
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_search_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(id.map);
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
        LatLng paris = new LatLng(48.864716, 2.349014);
        mMap.addMarker(new MarkerOptions().position(paris).title("Marker in Paris"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(paris, 12));
    }

    public void getData() {
        if (Network.isNetworkAvailable(SearchLocationActivity.this)) {

            // Instantiate the RequestQueue.
            RequestQueue queue = Volley.newRequestQueue(SearchLocationActivity.this);
            String url = Constant.URL_GET_MUSEUM; //l'url du web service

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) { // 200

                            Gson gson = new Gson(); //une instance d'un objet Gson (permet de décoder le fichier JSON qui est renvoyé par le serveur).

                            final DataGet dataGet = gson.fromJson(response, DataGet.class); //nous lançons le décodage (La lecture du fichier JSON renvoyé par le web service )
                            //Log.e(TAG, dataGet.geometry);

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    FastDialog.showDialog(SearchLocationActivity.this,
                            FastDialog.SIMPLE_DIALOG,
                            "Probleme");
                }
            });

            // Add the request to the RequestQueue.
            queue.add(stringRequest);
        } else {
            FastDialog.showDialog(SearchLocationActivity.this,
                    FastDialog.SIMPLE_DIALOG,
                    "Vous devez être connecté");
        }
    }
}
