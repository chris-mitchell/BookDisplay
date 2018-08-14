package com.possible.myapplication.di.modules;

import com.possible.core.data.repository.BooksRepository;
import com.possible.myapplication.ui.books.BooksViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Provides
    BooksViewModelFactory booksViewModelFactory(BooksRepository booksRepository) {
        return new BooksViewModelFactory(booksRepository);
    }
}
