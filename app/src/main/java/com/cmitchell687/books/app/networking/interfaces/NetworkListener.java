package com.cmitchell687.books.app.networking.interfaces;

/**
 * Created on 3/31/14.
 */
public interface NetworkListener<T> {
    public void onNetworkCompleted(T response);
    public void onNetworkFailed();
}
