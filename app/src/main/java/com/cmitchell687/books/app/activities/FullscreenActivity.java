package com.cmitchell687.books.app.activities;

import android.app.Activity;
import android.os.Bundle;

import com.cmitchell687.books.app.R;
import com.cmitchell687.books.app.adapters.BookAdapter;
import com.cmitchell687.books.app.fragments.BookListFragment;
import com.cmitchell687.books.app.networking.interfaces.NetworkListener;
import com.cmitchell687.books.app.networking.models.BookModel;
import com.cmitchell687.books.app.networking.producers.Books;

import java.util.List;

/**
 * An example full-screen activity
 *
 */
public class FullscreenActivity extends Activity implements NetworkListener<List<BookModel>> {

    private BookListFragment mBookFrag;
    private BookAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

        new Books().getData(this, this);

        mAdapter = new BookAdapter(this, R.layout.books_list_item);
        mBookFrag = (BookListFragment) getFragmentManager().findFragmentById(R.id.listview);
        mBookFrag.setEmptyText(getString(R.string.list_view_empty_data));
    }

    @Override
    public void onNetworkCompleted(List<BookModel> books) {
        mBookFrag.setListAdapter(mAdapter);
        mAdapter.setData(books);
    }

    @Override
    public void onNetworkFailed() {
        mBookFrag.setListAdapter(mAdapter);
    }
}
