package com.store.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.store.bookstore.dto.BuyerDTO;
import com.store.bookstore.dto.CartDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue
    private int orderId;
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Buyer buyer;

    private boolean order;
    public int totalPrice;
    public int totalBook;
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private List<Cart> cartList;


    public Order(int totalPrice, int totalBook, Buyer buyer, List<Cart> cartList) {
        this.totalPrice = totalPrice;
        this.totalBook = totalBook;
        this.buyer = buyer;
        this.cartList=cartList;
    }
}
