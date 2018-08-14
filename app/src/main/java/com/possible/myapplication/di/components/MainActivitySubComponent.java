package com.possible.myapplication.di.components;

import com.possible.myapplication.ui.MainActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
interface MainActivitySubComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {
    }
}
