package com.store.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.store.bookstore.dto.CartDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {

    @Id
    @GeneratedValue
    private int cartId;
    public int totalPrice;
    public int totalBook;


    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    public Cart(int totalPrice, int totalBook, Book book) {
        this.totalPrice = totalPrice;
        this.totalBook = totalBook;
        this.book = book;
    }
}
