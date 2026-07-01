package dev.aritrachats.librarymanagement_springboot;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private final BookRepository bookRepository;

    public LibraryService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Create
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Request
    public List<Book> ListAllBooks() {
        return bookRepository.findAll();
    }
    public Book findBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }
    public Book findBookByTitle(String title) {
        return bookRepository.findAll().stream().filter(book -> book.getTitle().equals(title))
                .findFirst().orElse(null);
    }
    public List<Book> findBookByAuthor(String author) {
        return bookRepository.findAll().stream().filter(book -> book.getAuthor().equals(author))
                .toList();
    }

    //Update
    public Book updateBookById(int id, Book updatedBook) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with id: " + id + " not found!"));
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        return bookRepository.save(book);
    }

    //Delete
    public Book deleteBookById(int id) {
        Book book = findBookById(id);
        bookRepository.deleteById(id);
        return book;
    }
    public long deleteAllBooks() {
        long bookCount = bookRepository.count();
        bookRepository.deleteAll();
        return bookCount;
    }
}
