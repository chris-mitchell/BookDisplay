package com.possible.myapplication.di.modules;

import com.possible.core.data.Webservice;
import com.possible.myapplication.di.scopes.PerApplication;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {

    @Provides
    @PerApplication
    Retrofit provideRetrofit() {

        OkHttpClient client = new OkHttpClient();

        return new Retrofit.Builder()
                .baseUrl("https://de-coding-test.s3.amazonaws.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    @PerApplication
    Webservice providesWebservice(Retrofit retrofit) {
        return retrofit.create(Webservice.class);
    }
}
