package com.possible.myapplication.ui.books;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.possible.core.data.repository.BooksRepository;

public class BooksViewModelFactory implements ViewModelProvider.Factory {

    private BooksRepository booksRepository;

    public BooksViewModelFactory(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(BooksViewModel.class)) {
            return (T) (new BooksViewModel(booksRepository));
        }
        throw new IllegalStateException("Unknown ViewModel class");
    }
}
