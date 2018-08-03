package com.possible.core.data.models;

import com.google.gson.annotations.SerializedName;

public class Book {
    public String title;
    @SerializedName("imageURL")
    public String imageUrl;
    public String author;
}
