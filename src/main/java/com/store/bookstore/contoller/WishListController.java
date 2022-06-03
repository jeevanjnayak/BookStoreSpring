package com.store.bookstore.contoller;

import com.store.bookstore.dto.ResponseDTO;
import com.store.bookstore.dto.WishListDTO;
import com.store.bookstore.entity.Wishlist;
import com.store.bookstore.service.IWishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wishlist")
public class WishListController {
    @Autowired
    IWishListService iWishListService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addBook(@RequestBody WishListDTO wishListDTO) {
        Wishlist wishList = iWishListService.addBook(wishListDTO);
        ResponseDTO responseDTO = new ResponseDTO("Book added Successfully", wishList);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteBookById(@PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO("", iWishListService.deleteBookById(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/show")
    public ResponseEntity<ResponseDTO> getCart() {
        ResponseDTO responseDTO = new ResponseDTO("All the Books shown Bellow", iWishListService.getWishList());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
