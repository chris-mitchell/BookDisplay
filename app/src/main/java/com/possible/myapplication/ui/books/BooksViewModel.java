package com.possible.myapplication.ui.books;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.databinding.Bindable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.possible.core.data.models.Book;
import com.possible.core.data.repository.BooksRepository;
import com.possible.core.data.status.Resource;
import com.possible.core.data.status.Status;
import com.possible.myapplication.BookApp;
import com.possible.myapplication.ui.common.Visibility;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class BooksViewModel extends ViewModel {

    private BooksRepository booksRepository;
    private LiveData<Resource<List<Book>>> books;

    public BooksViewModel(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @NonNull
    public LiveData<Resource<List<BookViewModel>>> getBooks() {
        if (books == null) {
            books = booksRepository.getBooks();
        }

        return Transformations.map(books, new Function<Resource<List<Book>>, Resource<List<BookViewModel>>>() {
            @Override
            public Resource<List<BookViewModel>> apply(Resource<List<Book>> input) {
                return new Resource<>(createBookViewModel(input.getData()), input.getStatus());
            }
        });
    }

    private List<BookViewModel> createBookViewModel(@Nullable List<Book> books) {
        List<BookViewModel> result = new ArrayList<>();
        if (books != null) {
            for (Book book : books) {
                BookViewModel bookModel = new BookViewModel(book);
                result.add(bookModel);
            }
        }

        return result;
    }

    @Visibility
    public int getLoadingVisibility() {
        if (books == null || books.getValue().getStatus() == Status.LOADING) {
            return View.VISIBLE;
        } else {
            return View.GONE;
        }
    }

    @Visibility
    public int getContentVisibility() {
        if (books != null && books.getValue().getStatus() == Status.SUCCESS) {
            return View.VISIBLE;
        } else {
            return View.GONE;
        }
    }

    @Visibility
    public int getErrorVisibility() {
        if (books != null && books.getValue().getStatus() == Status.ERROR) {
            return View.VISIBLE;
        } else {
            return View.GONE;
        }
    }
}
