package com.possible.myapplication.di.components;

import com.possible.myapplication.di.modules.AppModule;
import com.possible.core.di.modules.DataModule;
import com.possible.myapplication.ui.books.BooksViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DataModule.class, AppModule.class})
public interface UiComponent {

    void inject(BooksViewModel booksViewModel);
}
