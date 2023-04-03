package com.Bookstore.controllers;

import com.Bookstore.entities.Author;
import com.Bookstore.services.BookService;
import com.Bookstore.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;


    @GetMapping
    public List<Book> findALl(){
        return bookService.findAll();
    }

    @PostMapping
    public void findALl(@RequestBody Book book){
        bookService.saveBook(book);
    }

    @GetMapping("/{id}")
    public Book findALl(@PathVariable Integer id){
        return bookService.findById(id);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable Integer id,
                           @RequestParam(required = false) String title,
                           @RequestBody(required = false) Author author,
                           @RequestParam(required = false) String description){
        bookService.updateBook(id, title, author, description);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
    }


    @GetMapping("/search")
    public List<Optional<Book>> findByAuthor(@RequestParam Long authorId){
        return bookService.findByAuthor(authorId);
    }

    @GetMapping("/search")
    public List<Optional<Book>> findByTitle(@RequestParam String title) {
        return bookService.findByTitle(title);
    }

    @GetMapping("/sort/title/asc")
    public List<Book> getAllBooksSortedByTitleAsc() {
        return bookService.findAllBooksSortedByTitleAsc();
    }
    @GetMapping("/sort/title/desc")
    public List<Book> getAllBooksSortedByTitleDesc() {
        return bookService.findAllBooksSortedByTitleDesc();
    }
    @GetMapping("/sort/year/asc")
    public List<Book> getAllBooksSortedByPublicationYearAsc() {
        return bookService.findAllBooksSortedByPublicationYearAsc();
    }

    @GetMapping("/sort/year/desc")
    public List<Book> getAllBooksSortedByPublicationYearDesc() {
        return bookService.findAllBooksSortedByPublicationYearDesc();
    }

    //searches authors or titles using 1 param
    @GetMapping("/search")
    public List<Book> searchByTitleOrAuthor(@RequestParam String query){
        return bookService.searchByTitleOrAuthor(query, query);
    }
}
