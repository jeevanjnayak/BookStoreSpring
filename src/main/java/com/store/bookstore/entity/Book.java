package com.store.bookstore.entity;

import com.store.bookstore.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Book {

    @Id
    @GeneratedValue
    private int bookId;
    private String bookName;
    private String author;
    private int quantity;
    private int bookPrice;
    private LocalDate arrivalDate;


    public Book(BookDTO bookDTO) {
        this.bookName = bookDTO.getBookName();
        this.author = bookDTO.getAuthor();
        this.quantity = bookDTO.getQuantity();
        this.bookPrice = bookDTO.getBookPrice();
        this.arrivalDate = bookDTO.getArrivalDate();
    }

    public Book(BookDTO bookDTO , int bookId) {
        this.bookName = bookDTO.getBookName();
        this.author = bookDTO.getAuthor();
        this.quantity = bookDTO.getQuantity();
        this.bookPrice = bookDTO.getBookPrice();
        this.arrivalDate = bookDTO.getArrivalDate();
        this.bookId = bookId;
    }

}
