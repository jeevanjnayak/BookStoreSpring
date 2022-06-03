package com.store.bookstore.service;

import com.store.bookstore.dto.BuyerDTO;
import com.store.bookstore.dto.LoginDto;
import com.store.bookstore.dto.OrderDTO;
import com.store.bookstore.entity.Book;
import com.store.bookstore.entity.Buyer;

import java.util.List;

public interface IRegistrationService {
    String regdPerson(BuyerDTO buyerDTO);

    String login(LoginDto loginDto);
    Buyer getUserById(int id);

    List<Buyer> getUsers();
    String getEmail(int userId);

    Buyer getBookById(String token);
}
