package com.store.bookstore.service;

import com.store.bookstore.dto.BookDTO;
import com.store.bookstore.entity.Book;

import java.util.List;
import java.util.Optional;

public interface IBookStoreServices {
    Book addBook(BookDTO bookDTO);

    List<Book> getBookStore();

    Book getBookById(int id);

    String deleteBookById(int id);

    String editBook(BookDTO bookDTO, int id);

    List<Book> getBookByAuthor(String author);

    List<Book> getBookByName(String bookName);
}
