package com.store.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService{
    @Autowired
    private JavaMailSender javaMailSender;
    public void sendEmail(String receiverEmail, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("jeevanjnayak@gmail.com");
        message.setTo(receiverEmail);
        message.setText(body);
        message.setSubject(subject);

        javaMailSender.send(message);

        System.out.println("An email has been sent to your email address about the order");
    }
}
