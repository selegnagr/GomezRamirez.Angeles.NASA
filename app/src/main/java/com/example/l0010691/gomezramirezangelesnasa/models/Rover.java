package com.example.l0010691.gomezramirezangelesnasa.models;


import java.util.ArrayList;

/**
 * Created by Angeles Gomez.
 */
public class Rover {
    int id;
    String name;
    String landing_date;
    int max_sol;
    String max_date;
    int total_photos;
    ArrayList<Camera> cameras;

    public Rover(int id, String name, String landing_date, int max_sol, String max_date, int total_photos, ArrayList<Camera> cameras) {
        this.id = id;
        this.name = name;
        this.landing_date = landing_date;
        this.max_sol = max_sol;
        this.max_date = max_date;
        this.total_photos = total_photos;
        this.cameras = cameras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanding_date() {
        return landing_date;
    }

    public void setLanding_date(String landing_date) {
        this.landing_date = landing_date;
    }

    public int getMax_sol() {
        return max_sol;
    }

    public void setMax_sol(int max_sol) {
        this.max_sol = max_sol;
    }

    public String getMax_date() {
        return max_date;
    }

    public void setMax_date(String max_date) {
        this.max_date = max_date;
    }

    public int getTotal_photos() {
        return total_photos;
    }

    public void setTotal_photos(int total_photos) {
        this.total_photos = total_photos;
    }

    public ArrayList<Camera> getCameras() {
        return cameras;
    }

    public void setCameras(ArrayList<Camera> cameras) {
        this.cameras = cameras;
    }
}
