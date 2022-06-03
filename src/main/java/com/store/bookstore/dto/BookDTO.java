package com.store.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]+$", message = "Name is invalid! it must have at least 2 characters and the first character should be uppercase.")
    private String bookName;

    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]+$", message = "Name is invalid! it must have at least 2 characters and the first character should be uppercase.")
    private String author;

    private int quantity;

    private int bookPrice;

    @NotNull(message = "Please enter the Arrival date!")
    private LocalDate arrivalDate;
}
