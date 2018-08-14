package com.possible.myapplication.di;


import android.app.Application;

import com.possible.myapplication.BookApp;
import com.possible.myapplication.di.modules.ActivityBindingModule;
import com.possible.myapplication.di.modules.ApplicationModule;
import com.possible.myapplication.di.scopes.PerApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@PerApplication
@Component(modules = {ActivityBindingModule.class,
        ApplicationModule.class,
        AndroidSupportInjectionModule.class})
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);
        ApplicationComponent build();
    }

    void inject(BookApp bookApp);
}


