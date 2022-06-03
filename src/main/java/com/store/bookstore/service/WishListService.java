package com.store.bookstore.service;

import com.store.bookstore.dto.WishListDTO;
import com.store.bookstore.entity.Book;
import com.store.bookstore.entity.Wishlist;
import com.store.bookstore.repository.IWishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService implements IWishListService{
    @Autowired
    IWishListRepository iWishListRepository;

    @Autowired
    IBookStoreServices iBookStoreServices;

    @Override
    public Wishlist addBook(WishListDTO wishListDTO) {
        Book book = iBookStoreServices.getBookById(wishListDTO.getBookId());
        Wishlist wishlist1 = new Wishlist();
        Wishlist wishlist = new Wishlist(wishlist1.totalBook,book);
        wishlist.setTotalBook(iWishListRepository.findAll().size()+1);
        return iWishListRepository.save(wishlist);
    }

    @Override
    public String deleteBookById(int id) {
        iWishListRepository.deleteById(id);
        return "Book with id "+ id +" is deleted from Wishlist.";
    }

    @Override
    public List<Wishlist> getWishList() {
        return iWishListRepository.findAll();
    }
}
