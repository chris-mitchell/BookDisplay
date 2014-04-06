package com.cmitchell687.books.app.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cmitchell687.books.app.R;
import com.cmitchell687.books.app.networking.models.BookModel;
import com.koushikdutta.ion.Ion;

import java.util.List;

public class BookAdapter extends ArrayAdapter<BookModel> {

    public BookAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void setData(List<BookModel> books) {
        clear();
        addAll(books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BookHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.books_list_item, parent, false);
            holder = new BookHolder();
            holder.bookImage = (ImageView) convertView.findViewById(R.id.book_image);
            holder.author = (TextView) convertView.findViewById(R.id.author);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            convertView.setTag(holder);
        } else {
            holder = (BookHolder) convertView.getTag();
        }

        BookModel book = getItem(position);
        holder.title.setText(book.title);

        if (TextUtils.isEmpty(book.author)) {
            holder.author.setVisibility(View.GONE);
        } else {
            holder.author.setVisibility(View.VISIBLE);
            holder.author.setText(book.author);
        }

        if (!TextUtils.isEmpty(book.imageURL)) {
            Ion.with(getContext()).load(book.imageURL).intoImageView(holder.bookImage);
        } else {
            // Ensure we don't have view recycling issues.
            holder.bookImage.setImageBitmap(null);
        }

        return convertView;
    }

    @Override
    public boolean isEmpty() {
        return getCount() == 0;
    }

    private static class BookHolder {
        public ImageView bookImage;
        public TextView author;
        public TextView title;
    }
}
