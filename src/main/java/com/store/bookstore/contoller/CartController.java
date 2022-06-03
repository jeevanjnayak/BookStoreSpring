package com.store.bookstore.contoller;

import com.store.bookstore.dto.CartDTO;
import com.store.bookstore.dto.ResponseDTO;
import com.store.bookstore.entity.Cart;
import com.store.bookstore.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ICartService iCartService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addBook(@RequestBody CartDTO cartDTO) {
        Cart cart = iCartService.addBook(cartDTO);
        ResponseDTO responseDTO = new ResponseDTO("Book added Successfully", cart);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteBookById(@PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO("", iCartService.deleteBookById(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/show")
    public ResponseEntity<ResponseDTO> getCart() {
        ResponseDTO responseDTO = new ResponseDTO("All the Books shown Bellow", iCartService.getCart());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
