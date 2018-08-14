package com.possible.myapplication.di.modules;

import com.possible.myapplication.di.scopes.PerActivity;
import com.possible.myapplication.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    public abstract MainActivity bindMainActivity();

}
