package com.store.bookstore.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor

@Entity
public class Token {
    @Id
    @GeneratedValue
    private int tokenId;
    private String token;

    public Token(String token) {
        this.token = token;
    }
}
