package com.possible.myapplication.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.possible.core.data.status.Resource;
import com.possible.myapplication.R;
import com.possible.myapplication.databinding.ActivityMainBindingImpl;
import com.possible.myapplication.ui.books.BookViewModel;
import com.possible.myapplication.ui.books.BooksAdapter;
import com.possible.myapplication.ui.books.BooksViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BooksAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBindingImpl binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new BooksAdapter();
        recyclerView.setAdapter(adapter);

        final BooksViewModel viewModel = ViewModelProviders.of(this).get(BooksViewModel.class);
        viewModel.getBooks().observe(this, new Observer<Resource<List<BookViewModel>>>() {
            @Override
            public void onChanged(@Nullable Resource<List<BookViewModel>> books) {
                if (books != null && books.getData() != null) {
                    adapter.submitList(books.getData());
                }
                binding.setViewModel(viewModel);
            }
        });
        binding.setViewModel(viewModel);
    }
}
