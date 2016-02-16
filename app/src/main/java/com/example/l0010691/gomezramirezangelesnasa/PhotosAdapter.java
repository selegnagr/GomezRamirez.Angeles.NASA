package com.example.l0010691.gomezramirezangelesnasa;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.l0010691.gomezramirezangelesnasa.models.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Angeles Gomez
 */
public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder> {
    private List<Photo> items;
    private Context mContext;
    private  View v;
    public  class PhotoViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item

        public TextView fecha;
        public TextView nombre;
        public ImageView imagen;


        public PhotoViewHolder(View v) {
            super(v);
            fecha = (TextView) v.findViewById(R.id.fecha);
            nombre = (TextView) v.findViewById(R.id.nombre);
            imagen = (ImageView) v.findViewById(R.id.imagen);
       }
    }

    public PhotosAdapter(Context context,List<Photo> items) {
        this.items = items;
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.photo_card, viewGroup, false);
        return new PhotoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder viewHolder, int i) {
        if (i % 2 != 0) {
            System.out.println("Posicion IMPAR" + i + "de la lista.");
            v.setBackgroundResource(R.color.cardview_shadow_start_color);
        }

        viewHolder.fecha.setText(String.valueOf(items.get(i).getEarth_date()));
        viewHolder.nombre.setText(items.get(i).getCamera().getName());
        Picasso.with(mContext).load(items.get(i).getImg_src()).into(viewHolder.imagen);
        final int posicion = i;
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Picando en cada elemento del card url : "+ items.get(posicion).getImg_src());
                Intent intent = new Intent(mContext, FullscreenActivity.class);
                intent.putExtra("urlImagen", items.get(posicion).getImg_src());
                mContext.startActivity(intent);
            }
        });
    }

}
