package com.possible.core.data.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.possible.core.data.Webservice;
import com.possible.core.data.models.Book;
import com.possible.core.data.status.Resource;
import com.possible.core.data.status.Status;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BooksRepository {
    private static final String TAG = BooksRepository.class.getName();

    private Webservice webservice;
    private final MutableLiveData<Resource<List<Book>>> data = new MutableLiveData<>();


    @Inject
    public BooksRepository(Webservice webservice) {
        this.webservice = webservice;
    }

    public MutableLiveData<Resource<List<Book>>> getBooks() {
        if (data.getValue() == null) {
            Resource<List<Book>> resource = new Resource<>(Status.LOADING);
            data.setValue(resource);
        }

        webservice.getBooks().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(@NonNull Call<List<Book>> call, @NonNull Response<List<Book>> response) {
                Resource<List<Book>> resource = new Resource<>(response.body(), Status.SUCCESS);
                data.setValue(resource);
            }

            @Override
            public void onFailure(@NonNull Call<List<Book>> call, @NonNull Throwable t) {
                Log.e(TAG, t.getMessage());
                Resource<List<Book>> resource = new Resource<>(Status.ERROR);
                data.setValue(resource);
            }
        });

        return data;
    }
}
