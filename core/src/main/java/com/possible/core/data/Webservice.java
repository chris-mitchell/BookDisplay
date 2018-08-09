package com.possible.core.data;

import com.possible.core.data.models.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Webservice {

    @GET("books.json")
    Call<List<Book>> getBooks();

}
