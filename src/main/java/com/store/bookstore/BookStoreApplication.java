package com.store.bookstore;

import com.store.bookstore.service.EmailSenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
public class BookStoreApplication {

    @Autowired
    EmailSenderService emailSenderService;

    public static void main(String[] args) {

        SpringApplication.run(BookStoreApplication.class, args);
        System.out.println("Hello Person");
        log.info("Hello Jeevan");
    }

}
