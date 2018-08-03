package com.possible.core.data.status;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class Resource<T> {

    private T data;
    private Status status;

    public Resource(@NonNull Status status) {
        this.status = status;
    }

    public Resource(@Nullable T data, @NonNull Status status) {
        this.data = data;
        this.status = status;
    }

    @Nullable
    public T getData() {
        return data;
    }

    @NonNull
    public Status getStatus() {
        return status;
    }
}
