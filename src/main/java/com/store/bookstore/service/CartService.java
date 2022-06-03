package com.store.bookstore.service;

import com.store.bookstore.dto.BookDTO;
import com.store.bookstore.dto.CartDTO;
import com.store.bookstore.entity.Book;
import com.store.bookstore.entity.Buyer;
import com.store.bookstore.entity.Cart;
import com.store.bookstore.repository.IBookRepository;
import com.store.bookstore.repository.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    ICartRepository iCartRepository;

    @Autowired
    IBookStoreServices iBookStoreServices;

    @Autowired
    IRegistrationService iRegistrationService;

    @Override
    public Cart addBook(CartDTO cartDTO) {
        Book book = iBookStoreServices.getBookById(cartDTO.getBookId());
        Cart cart1 = new Cart();
        Cart cart = new Cart(cart1.totalPrice,cart1.totalBook,book);
        cart.setTotalBook(iCartRepository.findAll().size()+1);
        int temp1 = cart1.getTotalPrice();
        cart.setTotalPrice(temp1+=book.getBookPrice());
        return iCartRepository.save(cart);
    }
    @Override
    public String deleteBookById(int id) {
        iCartRepository.deleteById(id);
        return "Book Id : " +id+ " is deleted.";
    }

    @Override
    public List<Cart> getCart() {

        return iCartRepository.findAll();
    }
    public void deleteCart(){
        iCartRepository.deleteAll();
    }
}
