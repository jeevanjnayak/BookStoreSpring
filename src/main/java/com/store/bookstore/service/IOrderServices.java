package com.store.bookstore.service;

import com.store.bookstore.dto.OrderDTO;
import com.store.bookstore.entity.Cart;
import com.store.bookstore.entity.Order;

import java.util.List;

public interface IOrderServices {
    Order orderBook(OrderDTO orderDTO);
    List<Order> showOrder();
    Order getById(int orderId);
    String cancelOrder(int orderId);
}
