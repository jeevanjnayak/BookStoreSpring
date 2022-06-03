package com.store.bookstore.service;


import com.store.bookstore.dto.BookDTO;
import com.store.bookstore.dto.CartDTO;
import com.store.bookstore.entity.Book;
import com.store.bookstore.entity.Cart;

import java.util.List;

public interface ICartService {

    public Cart addBook(CartDTO cartDTO);
    String deleteBookById(int bookId);

    List<Cart> getCart();

    void deleteCart();
}
