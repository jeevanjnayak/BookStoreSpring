package com.store.bookstore.entity;

import com.store.bookstore.dto.BuyerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Buyer {

    @Id
    @GeneratedValue
    private int userId;
    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private String email;
    private String userName;

    public Buyer(BuyerDTO buyerDTO) {
        this.firstName = buyerDTO.getFirstName();
        this.lastName = buyerDTO.getLastName();
        this.password = buyerDTO.getPassword();
        this.address = buyerDTO.getAddress();
        this.email = buyerDTO.getEmail();
        this.userName = buyerDTO.getUserName();
    }
}
