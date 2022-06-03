package com.store.bookstore.service;

import com.store.bookstore.dto.OrderDTO;
import com.store.bookstore.entity.Book;
import com.store.bookstore.entity.Buyer;
import com.store.bookstore.entity.Cart;
import com.store.bookstore.entity.Order;
import com.store.bookstore.exception.CustomException;
import com.store.bookstore.repository.ICartRepository;
import com.store.bookstore.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServices implements IOrderServices {

    @Autowired
    IRegistrationService iRegistrationService;
    @Autowired
    ICartService iCartService;
    @Autowired
    ICartRepository iCartRepository;
    @Autowired
    IOrderRepository iOrderRepository;

    public Order orderBook(OrderDTO orderDTO) {
//        Book book = new Book();
        Buyer buyer = iRegistrationService.getUserById(orderDTO.getUserId());
        List<Cart> cartList = iCartService.getCart();
        Cart cart1 = new Cart();
        Order order = new Order(cart1.totalPrice,cart1.totalBook,buyer, cartList);
        order.setTotalBook(iCartRepository.findAll().size());
//        int temp1 = iCartRepository.getTotalPrice(cart1.getTotalPrice());
//        order.setTotalPrice(temp1+book.getBookPrice());
        iCartService.deleteCart();
        return iOrderRepository.save(order);
    }

    public List<Order> showOrder() {
        return iOrderRepository.findAll();
    }
    public Order getById(int orderId) {
        return iOrderRepository.findById(orderId).orElseThrow(() -> new CustomException("Order  with id " + orderId + " does not exist !"));

    }
    public String cancelOrder(int orderId) {
        Order order = getById(orderId);
        iOrderRepository.delete(order);
        return "your order has been cancelled";
    }

}