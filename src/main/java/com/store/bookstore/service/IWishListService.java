package com.store.bookstore.service;

import com.store.bookstore.dto.WishListDTO;
import com.store.bookstore.entity.Cart;
import com.store.bookstore.entity.Wishlist;

import java.util.List;

public interface IWishListService {
    Wishlist addBook(WishListDTO wishListDTO);

    String deleteBookById(int id);

    List<Wishlist> getWishList();
}
