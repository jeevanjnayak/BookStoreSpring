package com.store.bookstore.repository;

import com.store.bookstore.entity.Book;
import com.store.bookstore.entity.Buyer;
import com.store.bookstore.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepository extends JpaRepository<Cart,Integer> {
    @Query(value = "SELECT total_price FROM cart WHERE book_id = :book_id",nativeQuery = true)
    int getTotalPrice(int book_id);

}
