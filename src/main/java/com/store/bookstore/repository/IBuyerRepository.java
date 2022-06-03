package com.store.bookstore.repository;

import com.store.bookstore.dto.OrderDTO;
import com.store.bookstore.entity.Book;
import com.store.bookstore.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBuyerRepository extends JpaRepository<Buyer, Integer> {
    @Query(value = "SELECT * FROM buyer WHERE user_name = :userName",nativeQuery = true)
    Buyer getUser(String userName);

    @Query(value = "SELECT email FROM buyer WHERE user_id = :user_id",nativeQuery = true)
    Buyer getEmail(int user_id);
}
