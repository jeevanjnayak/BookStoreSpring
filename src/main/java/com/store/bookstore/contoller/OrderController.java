package com.store.bookstore.contoller;

import com.store.bookstore.dto.BookDTO;
import com.store.bookstore.dto.OrderDTO;
import com.store.bookstore.dto.ResponseDTO;
import com.store.bookstore.entity.Book;
import com.store.bookstore.entity.Order;
import com.store.bookstore.repository.IOrderRepository;
import com.store.bookstore.service.EmailSenderService;
import com.store.bookstore.service.IOrderServices;
import com.store.bookstore.service.IRegistrationService;
import com.store.bookstore.utill.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    IRegistrationService iRegistrationService;
    @Autowired
    IOrderServices iOrderServices;

    @Autowired
    IOrderRepository iOrderRepository;

    @Autowired
    EmailSender emailSender;

    @PostMapping("/done")
    public ResponseEntity<ResponseDTO> orderBook(@RequestBody OrderDTO orderDTO) {
        Order order = iOrderServices.orderBook(orderDTO);
        ResponseDTO responseDTO = new ResponseDTO("Book Ordered Successfully", order);
        ResponseDTO responseDTO1 = new ResponseDTO("Book Ordered Successfully", iOrderServices.showOrder());
        emailSender.sendMail(orderDTO);
        return new ResponseEntity<>(responseDTO1, HttpStatus.OK);
    }

    @PutMapping("/cancel/{id}")
    ResponseEntity<ResponseDTO> cancelOrder(@PathVariable int id) {
        ResponseDTO response = new ResponseDTO("your order has been cancelled ", iOrderServices.cancelOrder(id));
        emailSender.sendMail(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    ResponseEntity<ResponseDTO> getById(@PathVariable int id) {
        ResponseDTO response = new ResponseDTO("", iOrderServices.getById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/showall")
    ResponseEntity<ResponseDTO> getAllOrders() {
        ResponseDTO response = new ResponseDTO("", iOrderServices.showOrder());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
