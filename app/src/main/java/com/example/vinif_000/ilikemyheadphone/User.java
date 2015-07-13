package com.example.vinif_000.ilikemyheadphone;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by vinif_000 on 10/07/2015.
 */
public class User {
    private Bitmap profilepicture;
    private String description,headphone,marca;
    float rating;



    public User(Bitmap profilepicture, String description, float rating, String headphone, String marca) {
        super();
        this.profilepicture = profilepicture;
        this.rating = rating;
        this.description = description;
        this.headphone = headphone;
        this.marca = marca;

    }

    public Bitmap getProfilepicture() {
        return profilepicture;
    }

    public void setProfilepicture(Bitmap profilepicture) {
        this.profilepicture = profilepicture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getHeadphone() {
        return headphone;
    }

    public void setHeadphone(String headphone) {
        this.headphone = headphone;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
