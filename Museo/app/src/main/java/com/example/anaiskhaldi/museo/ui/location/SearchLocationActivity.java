package com.example.anaiskhaldi.museo.ui.location;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.anaiskhaldi.museo.R;
import com.example.anaiskhaldi.museo.models.DataGet;
import com.example.anaiskhaldi.museo.models.MuseumGetGeometryData;
import com.example.anaiskhaldi.museo.models.MuseumGetResults;
import com.example.anaiskhaldi.museo.utils.Constant;
import com.example.anaiskhaldi.museo.utils.FastDialog;
import com.example.anaiskhaldi.museo.utils.Network;
import com.example.anaiskhaldi.museo.utils.Preference;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import java.util.ArrayList;

import static android.R.attr.data;
import static com.example.anaiskhaldi.museo.R.*;

public class SearchLocationActivity extends FragmentActivity implements OnMapReadyCallback {

    private EditText editTextPlaces;

    private static final String TAG = "dataGetMap";
    private static final String TAG2 = "Preference";
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_search_location);

        editTextPlaces = (EditText) findViewById(id.editTextPlaces);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(id.map);
        mapFragment.getMapAsync(this);

        // L'écouteur PlaceSelectionListener se charge de renvoyer un lieu en réponse à la sélection de l'utilisateur
        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment) getFragmentManager().findFragmentById(id.place_autocomplete_fragment);
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Log.i(TAG, "Place: " + place.getName());
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });

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
        mMap = googleMap;

        getData();

        // Add a marker in Sydney and move the camera

        LatLng paris = new LatLng(Preference.getLatitude(SearchLocationActivity.this), Preference.getLongitude(SearchLocationActivity.this));
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

                            for(int i = 0; i< dataGet.results.size(); i++) {
                                MuseumGetGeometryData datas = dataGet.results.get(i).geometry;
                                Log.d(TAG, "geometrylat "+ datas.location.lat);
                                Log.d(TAG, "geometrylong "+ datas.location.lng);
                                Preference.setLatitude(SearchLocationActivity.this, datas.location.lat);;
                                Preference.setLongitude(SearchLocationActivity.this, datas.location.lng);
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            String message = new String(error.networkResponse.data);


                            FastDialog.showDialog(SearchLocationActivity.this,
                                    FastDialog.SIMPLE_DIALOG,
                                    "Probleme "+message);
                        }
                    }
            );

            // Add the request to the RequestQueue.
            queue.add(stringRequest);
        } else {
            FastDialog.showDialog(SearchLocationActivity.this,
                    FastDialog.SIMPLE_DIALOG,
                    "Vous devez être connecté");
        }
    }
}
