package com.Bookstore.repositories;

import com.Bookstore.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String title);

    Book findById(Integer id);

    List<Optional<Book>> findByAuthorId(Long id);

    List<Book> findByTitleContainingIgnoreCaseOrFindByAuthorContainingIgnoreCase(String title, String author);
}