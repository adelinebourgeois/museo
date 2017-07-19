package com.example.anaiskhaldi.museo.ui.detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.anaiskhaldi.museo.R;
import com.example.anaiskhaldi.museo.ui.search.SearchLocationActivity;
import com.example.anaiskhaldi.museo.utils.Constant;
import com.example.anaiskhaldi.museo.utils.Preference;
import com.squareup.picasso.Picasso;

public class PhotoActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageViewPhotoDetail;
    private  ImageView back3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        imageViewPhotoDetail = (ImageView) findViewById(R.id.imageViewPhotoDetail);
        back3 = (ImageView) findViewById(R.id.back3);

        if(getIntent().getExtras() != null) {
            String item =  getIntent().getExtras().getString("photo");

            String url = String.format(Constant.URL_GET_MUSEUM_PHOTO, item); //l'url du web service

            // Photo
            Picasso.with(PhotoActivity.this)
                    .load(url)
                    .into(imageViewPhotoDetail);
        }

        // Retour en arrière
        back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhotoActivity.this, DetailActivity.class);
                intent.putExtra(Constant.PLACE_ID, getIntent().getExtras().getString(Constant.PLACE_ID));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
