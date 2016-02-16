package com.example.l0010691.gomezramirezangelesnasa.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angeles Gomez
 * Objeto en el que se obtendrá el resultado del JSON con todos los elementos.
 */
public class ResultNasa {

    private List<Photo> photos = new ArrayList<Photo>();

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
