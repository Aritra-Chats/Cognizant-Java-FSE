package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    public BookService() {}
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Book Repository Injected through Constructor");
    }
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Book Repository Injected through Setter");
    }
    public void activateService() throws InterruptedException {
        System.out.println("Activating Book Service");
        Thread.sleep(500);
        System.out.println("Books Count: " + bookRepository.getBookCount());
        Thread.sleep(250);
        System.out.println("Book Service Activated");
    }
}
