package com.store.bookstore.utill;

import com.store.bookstore.dto.OrderDTO;
import com.store.bookstore.repository.IOrderRepository;
import com.store.bookstore.service.EmailSenderService;
import com.store.bookstore.service.IOrderServices;
import com.store.bookstore.service.IRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    IRegistrationService iRegistrationService;

    @Autowired
    IOrderServices iOrderServices;

    @Autowired
    IOrderRepository iOrderRepository;

//    @EventListener(ApplicationReadyEvent.class)
    public void sendMail(OrderDTO orderDTO) {
        emailSenderService.sendEmail("" + iRegistrationService.getEmail(orderDTO.getUserId()), "Order Successful", "your order was successful" + iOrderServices.showOrder().toString());
    }

    public void sendMail(int id) {
        emailSenderService.sendEmail("" + iRegistrationService.getEmail(id), "Order Cancelled Successful", "your order Cancelled successful" + iOrderServices.showOrder().toString());
    }
}
