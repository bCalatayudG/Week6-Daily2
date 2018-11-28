package com.example.user.amazonbooksexample.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

@Entity
public class Book{

    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int id;

    @SerializedName("imageURL")
    private String imageURL;

    @SerializedName("title")
    private String title;

    public void setImageURL(String imageURL){
        this.imageURL = imageURL;
    }

    public String getImageURL(){
        return imageURL;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    @Override
    public String toString(){
        return
                "BookResponse{" +
                        "imageURL = '" + imageURL + '\'' +
                        ",title = '" + title + '\'' +
                        "}";
    }
}
