package com.store.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyerDTO {
    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private String email;
    private String userName;
}
