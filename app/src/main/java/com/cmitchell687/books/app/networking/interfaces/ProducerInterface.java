package com.cmitchell687.books.app.networking.interfaces;

import android.content.Context;

/**
 * Created on 4/2/14.
 */
public interface ProducerInterface<T> {

    public abstract void getData(Context context, NetworkListener<T> listener);
    public abstract String getPath();

}
