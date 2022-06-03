package com.store.bookstore.repository;

import com.store.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "SELECT * FROM book WHERE author = :author",nativeQuery = true)
    List<Book> findByAuthor(String author);

    @Query(value = "SELECT * FROM book WHERE bookName = :bookName",nativeQuery = true)
    List<Book> findByName(String bookName);
}
