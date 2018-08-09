package com.possible.myapplication;

import android.app.Application;

import com.possible.myapplication.di.components.DaggerUiComponent;
import com.possible.myapplication.di.components.UiComponent;
import com.possible.myapplication.di.modules.AppModule;
import com.possible.core.di.modules.DataModule;

public class BookApp extends Application {

    private static UiComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerUiComponent.builder()
                .appModule(new AppModule(this))
                .dataModule(new DataModule("https://de-coding-test.s3.amazonaws.com/"))
                .build();

    }

    public static UiComponent getComponent() {
        return component;
    }
}
