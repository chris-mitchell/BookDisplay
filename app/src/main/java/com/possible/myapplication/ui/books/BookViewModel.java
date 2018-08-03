package com.possible.myapplication.ui.books;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.possible.core.data.models.Book;

public class BookViewModel extends ViewModel {

    private String author;
    private String title;
    private String imageUrl;

    public BookViewModel(Book book) {
        this.title = book.title;
        this.author = book.author;
        this.imageUrl = book.imageUrl;
    }

    @Nullable
    public String getAuthor() {
        return author;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    @Nullable
    public String getImageUrl() {
        return imageUrl;
    }
}
