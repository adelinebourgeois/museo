package com.example.anaiskhaldi.museo.ui.detail;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anaiskhaldi.museo.models.detail.DetailPhoto;
import com.example.anaiskhaldi.museo.utils.Constant;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.example.anaiskhaldi.museo.R.id.imageViewPhoto;

/**
 * Created by Adeline on 18/07/2017.
 */

public class GalleryAdapter extends ArrayAdapter<DetailPhoto> {
    private LayoutInflater inflater;
    private int resId;

    //paramètres: this, R.layout.item_gallery, photoList
    public GalleryAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<DetailPhoto> objects) {
        super(context, resource, objects);

        resId = resource; // R.layout.item_gallery //chemin de la resources, du layout
        inflater = LayoutInflater.from(context); // init inflater // inflater permet le remplacement de zone
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder; // déclaration

        //remplacement de la vue par notre layout item_gallery
        if(convertView == null) {
            convertView = inflater.inflate(resId, null);

            viewHolder = new ViewHolder(); // instance

            //Récup des vues
            viewHolder.imageViewPhoto = (ImageView) convertView.findViewById(imageViewPhoto);

            convertView.setTag(viewHolder); //enregistre le ViewHolder qui contient la photo;

        } else {
            viewHolder = (ViewHolder) convertView.getTag(); //Recup de l'ImageView
        }

        // mise à jour des données
        DetailPhoto item = getItem(position);

        String url = String.format(Constant.URL_GET_MUSEUM_PHOTO, item.photo_reference); //l'url du web service

        // Photo
            Picasso.with(getContext())
                        .load(url)
                        .into(viewHolder.imageViewPhoto);

        return convertView;
    }

    class ViewHolder {

       ImageView imageViewPhoto;
    }
}
