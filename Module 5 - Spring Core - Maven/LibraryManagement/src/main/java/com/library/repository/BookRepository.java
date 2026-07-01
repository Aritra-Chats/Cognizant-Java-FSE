package com.library.repository;

import java.util.List;
import java.util.ArrayList;

public class BookRepository {
    List<String>  books;
    public BookRepository() {
        books = new ArrayList<>();
    }
    public int getBookCount() {
        return books.size();
    }
}
