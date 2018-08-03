package com.possible.myapplication.ui.books;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.possible.myapplication.databinding.BookItemBinding;

public class BooksAdapter extends ListAdapter<BookViewModel, BooksAdapter.BookViewHolder> {

    public BooksAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        BookItemBinding binding = BookItemBinding.inflate(inflater, viewGroup, false);

        return new BookViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder bookViewHolder, int i) {
        BookViewModel book = getItem(i);
        bookViewHolder.bind(book);
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {

        private BookItemBinding binding;

        public BookViewHolder(BookItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(BookViewModel book) {
            binding.setBook(book);
            binding.executePendingBindings();
        }
    }

    private static final DiffUtil.ItemCallback<BookViewModel> DIFF_CALLBACK = new DiffUtil.ItemCallback<BookViewModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull BookViewModel book1, @NonNull BookViewModel book2) {
            return book1 == book2;
        }

        @Override
        public boolean areContentsTheSame(@NonNull BookViewModel book1, @NonNull BookViewModel book2) {
            return book1.equals(book2);
        }
    };
}
