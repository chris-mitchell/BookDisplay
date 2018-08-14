package com.possible.myapplication.ui.books;

import com.possible.core.data.models.Book;
import com.possible.core.data.status.Resource;
import com.possible.core.data.status.Status;

import java.util.ArrayList;
import java.util.List;

public class BookFactory {

    public static Resource<List<Book>> makeBookResource(Status status, int count) {
        return new Resource<>(makeBookList(count), status);
    }

    public static List<Book> makeBookList(int count) {
        List<Book> books = new ArrayList<>(count);
        while (count > 0) {
            books.add(makeBook());
            count--;
        }

        return books;
    }

    private static Book makeBook() {
        Book book = new Book();
        book.author = "Test Author";
        book.imageUrl = "http://i.ebayimg.com/00/$(KGrHqR,!igE6M5wILm(BOuWZc0bjg~~_6.JPG?set_id=89040003C1";
        book.title = "Test title";
        return book;
    }
}
