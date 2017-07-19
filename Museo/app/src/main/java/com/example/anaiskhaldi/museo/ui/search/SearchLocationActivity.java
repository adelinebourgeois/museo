package com.example.anaiskhaldi.museo.ui.search;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.anaiskhaldi.museo.R;
import com.example.anaiskhaldi.museo.models.detail.DetailPhoto;
import com.example.anaiskhaldi.museo.models.museum.DataGet;
import com.example.anaiskhaldi.museo.models.museum.MuseumGetGeometryData;
import com.example.anaiskhaldi.museo.models.location.LocationGet;
import com.example.anaiskhaldi.museo.ui.detail.DetailActivity;
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

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.List;

import static com.example.anaiskhaldi.museo.R.*;

public class SearchLocationActivity extends FragmentActivity implements OnMapReadyCallback {

    // Déclaration des ids
    private EditText editTextSearchLocation;


    // Déclaration de la carte
    private GoogleMap mMap;

    //List des markers
    private List<Marker> markerList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_search_location);

        // Stockage des éléments du layout
        editTextSearchLocation = (EditText) findViewById(R.id.editTextSearchLocation);

        markerList = new ArrayList<Marker>();

        // Affichage de la map après les changement demandés dans le onMapReady
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Si on revient de l'écran DetailActivity , on garde les markers de la recherche
        if (getIntent().getExtras() != null) {
            Boolean item = getIntent().getExtras().getBoolean(Constant.BOOLEAN);

            if (item) {
                editTextSearchLocation.setText(Preference.getLocation(SearchLocationActivity.this));

                getMuseumLocation();

                // Si on clique sur Enter du clavier alors on recupere la location et on ferme le clavier
                editTextSearchLocation.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                        if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) || (keyCode == KeyEvent.KEYCODE_ENTER)) {

                            if (editTextSearchLocation.getText().toString().length() > 0) {

                                hideKeyboard(view); // Fait disparaitre le clavier
                                mMap.clear(); // clear la map
                                getLocation(); // recupère les lat/lng du lieux saisis

                            }
                            return true;
                        }
                        return false;
                    }
                });

                // Si on clique sur le bouton loupe alors on recupere la location et on ferme le clavier
                editTextSearchLocation.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        final int DRAWABLE_LEFT = 0;
                        final int DRAWABLE_TOP = 1;
                        final int DRAWABLE_RIGHT = 2;
                        final int DRAWABLE_BOTTOM = 3;
                        if (event.getAction() == MotionEvent.ACTION_UP) {
                            if (event.getRawX() <= (editTextSearchLocation.getCompoundDrawables()[DRAWABLE_LEFT].getBounds().width()) + 100) {
                                if (editTextSearchLocation.getText().toString().length() > 0) {

                                    mMap.clear();
                                    hideKeyboard(v);
                                    getLocation();

                                }
                                return true;
                            }
                        }
                        return false;
                    }
                });
            }
        } else {
            editTextSearchLocation.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                    if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) || (keyCode == KeyEvent.KEYCODE_ENTER)) {

                        if (editTextSearchLocation.getText().toString().length() > 0) {

                            hideKeyboard(view);
                            mMap.clear();
                            getLocation();

                        }
                        return true;
                    }
                    return false;
                }
            });

            // Si on clique sur le bouton loupe alors on recupere la location et on ferme le clavier
            editTextSearchLocation.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    final int DRAWABLE_LEFT = 0;
                    final int DRAWABLE_TOP = 1;
                    final int DRAWABLE_RIGHT = 2;
                    final int DRAWABLE_BOTTOM = 3;
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        if (event.getRawX() <= (editTextSearchLocation.getCompoundDrawables()[DRAWABLE_LEFT].getBounds().width()) + 100) {
                            if (editTextSearchLocation.getText().toString().length() > 0) {

                                hideKeyboard(v);
                                mMap.clear();
                                getLocation();

                            }
                            return true;
                        }
                    }
                    return false;
                }
            });
        }
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

        // Add a marker in Paris and move the camera
        LatLng paris = new LatLng(48.856614, 2.3522219);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(paris, 12));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker arg0) {
                if(arg0 != null) {

                    Intent intentMarker = new Intent(SearchLocationActivity.this, DetailActivity.class);
                    intentMarker.putExtra(Constant.PLACE_ID, arg0.getTitle());

                    startActivity(intentMarker);
                }
                return true;
            }

        });

    }

    private void getLocation() {

        // Stockage du contenu du textEdit dans une variable
        String location = editTextSearchLocation.getText().toString();
        // Retire les espaces pour les remplacer par des + pour la requete
        String locationNoSpace = location.replaceAll("\\s","+");

        Preference.setLocation(SearchLocationActivity.this, locationNoSpace);


        if(location != null){

            // Vérification de la viabilité du réseau internet
            if(Network.isNetworkAvailable(SearchLocationActivity.this)){
                final Dialog dialog = FastDialog.showProgressDialog(SearchLocationActivity.this, "Chargement..."); // une pop up "chargement ...".

                // Afficher un loader
                dialog.show();

                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(SearchLocationActivity.this);
                String url = String.format(Constant.URL_GET_COORDONNATE, locationNoSpace);


                // Lancer la requête
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        dialog.dismiss();

                        Gson gson = new Gson();
                        LocationGet location = gson.fromJson(response, LocationGet.class);

                        if(location.status.equals("OK")){

                            // On stocke les informations de coordonnées dont places aura besoin dans les preferences
                            String coordinates = location.results.get(0).geometry.location.lat + "," + location.results.get(0).geometry.location.lng;
                            Preference.setSearchLocationCoordinate(SearchLocationActivity.this, coordinates);

                            getMuseumLocation();

                        } else {

                            FastDialog.showDialog(SearchLocationActivity.this, FastDialog.SIMPLE_DIALOG, location.error_message);

                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        FastDialog.showDialog(SearchLocationActivity.this, FastDialog.SIMPLE_DIALOG, getString(string.dialog_error));
                    }
                });

                // Add the request to the RequestQueue.
                queue.add(stringRequest);


            } else {

                FastDialog.showDialog(SearchLocationActivity.this, FastDialog.SIMPLE_DIALOG, getString(R.string.dialog_internet_error));

            }
        } else {

            FastDialog.showDialog(SearchLocationActivity.this, FastDialog.SIMPLE_DIALOG, getString(string.editText_error));

        }

    }

    public void getMuseumLocation() {


        if (Network.isNetworkAvailable(SearchLocationActivity.this)) {
            final Dialog dialog = FastDialog.showProgressDialog(SearchLocationActivity.this, getString(string.chargement_musee)); // Pop up de chargement.

            // Afficher un loader
            dialog.show();

            // Instantiate the RequestQueue.
            RequestQueue queue = Volley.newRequestQueue(SearchLocationActivity.this);
            String url = String.format(Constant.URL_GET_MUSEUM, Preference.getSearchLocationCoordinate(SearchLocationActivity.this)); //l'url du web service

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) { // 200
                            // cache le loader
                            dialog.cancel();


                            Gson gson = new Gson(); // Permet de décoder le fichier JSON qui est renvoyé par le serveur.
                            final DataGet dataGet = gson.fromJson(response, DataGet.class); // Lecture du fichier JSON renvoyé par le web service

                            if(dataGet.status.equals("OK")) {

                                for (int i = 0; i < dataGet.results.size(); i++) {

                                    MuseumGetGeometryData datas = dataGet.results.get(i).geometry;
                                    addMarker(datas.location.lat, datas.location.lng, dataGet.results.get(i).place_id);
                                }

                           } else {

                               FastDialog.showDialog(SearchLocationActivity.this, FastDialog.SIMPLE_DIALOG, getString(string.dialog_error));
                           }

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            // cache le loader
                            dialog.dismiss();

                            String message = new String(error.networkResponse.data);

                            FastDialog.showDialog(SearchLocationActivity.this, FastDialog.SIMPLE_DIALOG, getString(string.dialog_error));
                        }
                    }
            );


            // Add the request to the RequestQueue.
            queue.add(stringRequest);
            // cacher la boîte de dialogue
            dialog.dismiss();
        } else {

            FastDialog.showDialog(SearchLocationActivity.this, FastDialog.SIMPLE_DIALOG, getString(string.dialog_internet_error));
        }

    }


    public void addMarker(Float lat, Float lng, String placeId){
        Marker marker;

        // Change et resize le marker
        int height = 131;
        int width = 100;
        BitmapDrawable bitmapdraw = (BitmapDrawable)getResources().getDrawable(drawable.splashscreen_marker_red);
        Bitmap b = bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);


        // Ajoute le marker
        LatLng location = new LatLng(lat,lng);

        MarkerOptions info = new MarkerOptions()
                .position(location)
                .title(placeId)
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker));

        marker = mMap.addMarker(info);
        markerList.add(marker);


        // Stocke les coordonnées et zoom
        String coordinateSearch = Preference.getSearchLocationCoordinate(SearchLocationActivity.this);
        String[] parts = coordinateSearch.split(",");
        String coorLat = parts[0];
        String cootLng = parts[1];

        double latitude = Double.parseDouble(coorLat);
        double longitude = Double.parseDouble(cootLng);

        LatLng locationSearch = new LatLng(latitude, longitude);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(locationSearch, 16));

    }

    // Cache le clavier
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(SearchLocationActivity.this.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
