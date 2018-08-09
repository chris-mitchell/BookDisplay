package com.possible.core.di.modules;

import android.app.Application;

import com.possible.core.data.Webservice;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule {

    private String baseUrl;

    public DataModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Application application) {

        OkHttpClient client = new OkHttpClient();

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    Webservice providesWebservice(Retrofit retrofit) {
        return retrofit.create(Webservice.class);
    }
}
