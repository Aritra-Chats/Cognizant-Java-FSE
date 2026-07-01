package dev.aritrachats.librarymanagement_springboot;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Library")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) { return libraryService.addBook(book); }

    @GetMapping
    public List<Book> getBooks() { return libraryService.ListAllBooks(); }
    @GetMapping("{id}")
    public Book getBookById(@PathVariable Integer id) { return libraryService.findBookById(id); }
    @GetMapping("title/{title}")
    public Book getBookByTitle(@PathVariable String title) { return libraryService.findBookByTitle(title); }
    @GetMapping("author/{author}")
    public List<Book> getBookById(@PathVariable String author) { return libraryService.findBookByAuthor(author); }

    @PutMapping("{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book book) {
        return libraryService.updateBookById(id, book);
    }

    @DeleteMapping("{id}")
    public Book deleteBookById(@PathVariable Integer id) { return libraryService.deleteBookById(id); }
    @DeleteMapping
    public long deleteAllBooks() { return libraryService.deleteAllBooks(); }
}
