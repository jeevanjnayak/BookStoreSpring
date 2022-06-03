package com.store.bookstore.contoller;

import com.store.bookstore.dto.BookDTO;
import com.store.bookstore.dto.ResponseDTO;
import com.store.bookstore.entity.Book;
import com.store.bookstore.service.IBookStoreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    IBookStoreServices iBookStoreServices;

    @PostMapping("/adding")
    public ResponseEntity<ResponseDTO> addBook(@Valid @RequestBody BookDTO bookDTO) {
        Book book = iBookStoreServices.addBook(bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Book added Successfully", book);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/showall")
    public ResponseEntity<ResponseDTO> getAllBooks() {
        ResponseDTO responseDTO = new ResponseDTO("All the Books shown Bellow", iBookStoreServices.getBookStore());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //deleting the employee with a particular id from the DB using Delete mapping
    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<ResponseDTO> deleteBookById(@PathVariable int bookId) {
        ResponseDTO responseDTO = new ResponseDTO("Employee with id " + bookId + " Deleted Successfully", iBookStoreServices.deleteBookById(bookId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //getting the employee with a particular id from the DB and updating the data and storing to DB using put mapping
    @PutMapping("/edit/{bookId}")
    public ResponseEntity<ResponseDTO> editBookById(@Valid @RequestBody BookDTO bookDTO, @PathVariable int bookId) {
        ResponseDTO responseDTO = new ResponseDTO("Book details with id " + bookId + " Updated Successfully", iBookStoreServices.editBook(bookDTO, bookId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
