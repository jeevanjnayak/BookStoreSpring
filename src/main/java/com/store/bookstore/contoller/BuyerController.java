package com.store.bookstore.contoller;

import com.store.bookstore.dto.BookDTO;
import com.store.bookstore.dto.BuyerDTO;
import com.store.bookstore.dto.LoginDto;
import com.store.bookstore.dto.ResponseDTO;
import com.store.bookstore.entity.Book;
import com.store.bookstore.entity.Buyer;
import com.store.bookstore.service.IBookStoreServices;
import com.store.bookstore.service.IRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class BuyerController {

    @Autowired
    IBookStoreServices iBookStoreServices;

    @Autowired
    IRegistrationService iRegistrationService;

    @PostMapping("/regd")
    public ResponseEntity<String> regdPerson(@Valid @RequestBody BuyerDTO buyerDTO) {
        String token = iRegistrationService.regdPerson(buyerDTO);
        ResponseDTO responseDTO = new ResponseDTO("Book added Successfully", token);
        return new ResponseEntity<>(responseDTO.toString(), HttpStatus.CREATED);
    }
    @GetMapping("/login")
    public ResponseEntity<ResponseDTO> getUser(@RequestBody LoginDto loginDto){
        ResponseDTO responseDTO = new ResponseDTO("",iRegistrationService.login(loginDto));
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/showtoken/{token}")
    public ResponseEntity<ResponseDTO> getUserById(@PathVariable String token) {
        ResponseDTO responseDTO = new ResponseDTO("user with id Shown bellow", iRegistrationService.getBookById(token));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<ResponseDTO> getAllUsers() {
        ResponseDTO responseDTO = new ResponseDTO("All the Users shown Bellow", iRegistrationService.getUsers());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //getting all the employee and showing in a list form from the DB using get mapping
    @GetMapping("/showall")
    public ResponseEntity<ResponseDTO> getAllBooks() {
        ResponseDTO responseDTO = new ResponseDTO("All the Books shown Bellow", iBookStoreServices.getBookStore());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //getting the employee with a particular id from the DB and showing using get mapping
    @GetMapping("/show/{bookId}")
    public ResponseEntity<ResponseDTO> getBookById(@PathVariable int bookId) {
        ResponseDTO responseDTO = new ResponseDTO("Book with id " + bookId + " Shown bellow", iBookStoreServices.getBookById(bookId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<ResponseDTO> getBooksByAuthor(@PathVariable String author){
        List<Book> bookList = iBookStoreServices.getBookByAuthor(author);
        ResponseDTO responseDTO = new ResponseDTO("Book with "+author+" list gotten successfully",bookList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @GetMapping("/name/{bookName}")
    public ResponseEntity<ResponseDTO> getBooksByName(@PathVariable String bookName){
        List<Book> bookList = iBookStoreServices.getBookByName(bookName);
        ResponseDTO responseDTO = new ResponseDTO("Book with "+bookName+" list gotten successfully",bookList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}
