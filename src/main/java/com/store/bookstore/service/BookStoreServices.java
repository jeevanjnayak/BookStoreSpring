package com.store.bookstore.service;

import com.store.bookstore.dto.BookDTO;
import com.store.bookstore.entity.Book;
import com.store.bookstore.exception.CustomException;
import com.store.bookstore.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookStoreServices implements IBookStoreServices{

    @Autowired
    IBookRepository iBookRepository;

    @Override
    public Book addBook(BookDTO bookDTO) {
        Book book = new Book(bookDTO);
        return iBookRepository.save(book);
    }

    @Override
    public List<Book> getBookStore() {

        return iBookRepository.findAll();
    }

    @Override
    public Book getBookById(int bookId) {
        return iBookRepository.findById(bookId).orElseThrow(() -> new CustomException("Book  with id " + bookId + " does not exist in database..!"));
    }

    @Override
    public String deleteBookById(int bookId) {
        if (iBookRepository.findById(bookId).isPresent()){
            iBookRepository.deleteById(bookId);
            return "Book Id : " +bookId+ " is deleted.";
        }
        return "Book not Available at this moment.";
    }

    @Override
    public String editBook(BookDTO bookDTO, int bookId) {
        if (iBookRepository.findById(bookId).isPresent()) {
            Book book = new Book(bookDTO , bookId);
            book.setBookId(bookId);
            Book string = iBookRepository.save(book);
            return string.toString();
        }
        return null;
    }

    @Override
    public List<Book> getBookByAuthor(String author) {
        return iBookRepository.findByAuthor(author);
    }

    @Override
    public List<Book> getBookByName(String bookName) {
        return iBookRepository.findByName(bookName);
    }
}
