package com.Bookstore.services;

import com.Bookstore.entities.Author;
import com.Bookstore.entities.Book;
import com.Bookstore.repositories.AuthorRepository;
import com.Bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book findById(Integer id){
        return bookRepository.findById(id);
    }

    public void saveBook(Book book){
        bookRepository.save(book);
    }

    @Transactional
    public void updateBook(Integer id, String title, Author author, String description) {
        Book book = bookRepository.findById(id);
        if (title!=null && title.length()>0){
            book.setTitle(title);
        }
        if (author!=null){
            book.setAuthor(author);
        }
        if (description!=null && description.length()>0){
            book.setDescription(description);
        }
    }

    @Transactional
    public void deleteBook(Integer id){
        Book book = bookRepository.findById(id);
        bookRepository.delete(book);
    }

    public List<Optional<Book>> findByAuthor(Long id){
        return bookRepository.findByAuthorId(id);
    }
    public List<Optional<Book>> findByTitle(String title) {
        List<Book> books = bookRepository.findByTitleContainingIgnoreCase(title);
        return books.stream().map(Optional::ofNullable).collect(Collectors.toList());
    }

    public List<Book> findAllBooksSortedByTitleAsc() {
        Sort sort = Sort.by("title").ascending();
        return bookRepository.findAll(sort);
    }

    public List<Book> findAllBooksSortedByTitleDesc() {
        Sort sort = Sort.by("title").descending();
        return bookRepository.findAll(sort);
    }

    public List<Book> findAllBooksSortedByPublicationYearAsc() {
        Sort sort = Sort.by("publicationYear").ascending();
        return bookRepository.findAll(sort);
    }

    public List<Book> findAllBooksSortedByPublicationYearDesc() {
        Sort sort = Sort.by("yearPublished").descending();
        return bookRepository.findAll(sort);
    }

    public List<Book> searchByTitleOrAuthor(String title, String author){
        return bookRepository.findByTitleContainingIgnoreCaseOrFindByAuthorContainingIgnoreCase(title, author);
    }

}
