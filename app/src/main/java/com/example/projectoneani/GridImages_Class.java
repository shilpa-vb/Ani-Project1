package com.example.projectoneani;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GridImages_Class implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("previewURL")
    private String previewURL;
    @SerializedName("largeImageURL")
    private String largeImageURL;

    public GridImages_Class(int id, String previewURL, String largeImageURL) {
        this.id = id;
        this.previewURL = previewURL;
        this.largeImageURL = largeImageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }
}
