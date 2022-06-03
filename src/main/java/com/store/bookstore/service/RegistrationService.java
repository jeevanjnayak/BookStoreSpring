package com.store.bookstore.service;

import com.store.bookstore.dto.BuyerDTO;
import com.store.bookstore.dto.LoginDto;
import com.store.bookstore.dto.OrderDTO;
import com.store.bookstore.dto.TokenDTO;
import com.store.bookstore.entity.Buyer;
import com.store.bookstore.entity.Token;
import com.store.bookstore.exception.CustomException;
import com.store.bookstore.repository.IBuyerRepository;
import com.store.bookstore.repository.ITokenRepository;
import com.store.bookstore.utill.TokenUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService implements IRegistrationService{

    @Autowired
    IBuyerRepository iBuyerRepository;

    @Autowired
    TokenUtill tokenUtill;
    @Autowired
    ITokenRepository iTokenRepository;

    @Override
    public String regdPerson(BuyerDTO buyerDTO) {
        Buyer buyer = new Buyer(buyerDTO);
        if (!iBuyerRepository.findAll().toString().contains(buyer.getUserName())) {
            iBuyerRepository.save(buyer);
            String token = tokenUtill.createToken(buyer.getUserId());
            Token token1 = new Token(token);

            iTokenRepository.save(token1);
            return token;
        }
        else
            return "";
    }
    @Override
    public String login(LoginDto loginDto) {
        Optional<Buyer> loginUser = Optional.ofNullable(iBuyerRepository.getUser(loginDto.getUserName()));
        if (loginUser.isPresent()){
            if (loginUser.get().getPassword().equals(loginDto.getPassword())) {
                return "login successful";
            }
        }
        return "login failed";
    }
    public Buyer getUserById(int id) {
        return iBuyerRepository.findById(id).orElseThrow(() -> new CustomException("User  with id " + id + " does not exist in database..!"));
    }
    @Override
    public List<Buyer> getUsers() {
        return iBuyerRepository.findAll();
    }
    public String getEmail(int userId){
        return iBuyerRepository.getEmail(userId).toString();
    }

    @Override
    public Buyer getBookById(String token) {
        int id = tokenUtill.decodeToken(token);
        System.out.println("id is "+id);
        return iBuyerRepository.findById(id).orElseThrow(() -> new CustomException("User  does not exist in database..!"));
    }
}
