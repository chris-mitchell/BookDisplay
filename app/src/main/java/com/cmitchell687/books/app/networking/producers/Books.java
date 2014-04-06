package com.cmitchell687.books.app.networking.producers;

import android.content.Context;

import com.cmitchell687.books.app.networking.interfaces.NetworkListener;
import com.cmitchell687.books.app.networking.interfaces.ProducerInterface;
import com.cmitchell687.books.app.networking.models.BookModel;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.List;

/**
 * Created on 3/31/14.
 */
public class Books implements ProducerInterface<List<BookModel>> {

    private static final String PATH = "LINK_TO_BOOKS.JSON";

    @Override
    public void getData(Context context, final NetworkListener<List<BookModel>> listener) {
        Ion.with(context, getPath()).as(new TypeToken<List<BookModel>>(){})
                .setCallback(new FutureCallback<List<BookModel>>() {
            @Override
            public void onCompleted(Exception e, List<BookModel> result) {
                if (listener != null) {
                    if (e != null) {
                        listener.onNetworkFailed();
                    } else {
                        listener.onNetworkCompleted(result);
                    }
                }
            }
        });
    }

    @Override
    public String getPath() {
        return PATH;
    }
}
