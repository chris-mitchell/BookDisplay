package com.possible.myapplication.ui.books;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.*;
import android.view.View;
import com.possible.core.data.models.Book;
import com.possible.core.data.repository.BooksRepository;
import com.possible.core.data.status.Resource;
import com.possible.core.data.status.Status;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BooksViewModelTest {

    @Mock
    private BooksRepository booksRepository;

    @Mock
    Observer<Resource<List<BookViewModel>>> observer = mock(Observer.class);


    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    private BooksViewModel booksViewModel;


    @Before
    public void setUp() {
        booksRepository = mock(BooksRepository.class);

        booksViewModel = new BooksViewModel(booksRepository);
    }

    @Test
    public void getBooksReturnsSuccess() {

        MutableLiveData<Resource<List<Book>>> result = new MutableLiveData<>();
        result.setValue(BookFactory.makeBookResource(Status.SUCCESS, 10));

        when(booksRepository.getBooks()).thenReturn(result);
        booksViewModel.getBooks().observeForever(observer);

        assert(booksViewModel.getLoadingVisibility() == View.GONE);
        assert(booksViewModel.getContentVisibility() == View.VISIBLE);
        assert(booksViewModel.getErrorVisibility() == View.GONE);

    }

    @Test
    public void getBooksReturnsError() {

        MutableLiveData<Resource<List<Book>>> result = new MutableLiveData<>();
        result.postValue(BookFactory.makeBookResource(Status.ERROR, 0));

        when(booksRepository.getBooks()).thenReturn(result);
        booksViewModel.getBooks().observeForever(observer);

        assert(booksViewModel.getLoadingVisibility() == View.GONE);
        assert(booksViewModel.getContentVisibility() == View.GONE);
        assert(booksViewModel.getErrorVisibility() == View.VISIBLE);

    }

    @Test
    public void getLoadingVisibility() {

        MutableLiveData<Resource<List<Book>>> result = new MutableLiveData<>();
        result.postValue(BookFactory.makeBookResource(Status.LOADING, 0));

        when(booksRepository.getBooks()).thenReturn(result);
        booksViewModel.getBooks().observeForever(observer);

        assert(booksViewModel.getLoadingVisibility() == View.VISIBLE);
        assert(booksViewModel.getContentVisibility() == View.GONE);
        assert(booksViewModel.getErrorVisibility() == View.GONE);
    }

}