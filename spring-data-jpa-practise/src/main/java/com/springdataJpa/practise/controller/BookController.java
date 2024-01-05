package com.springdataJpa.practise.controller;


import com.springdataJpa.practise.entity.Book;
import com.springdataJpa.practise.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

//    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
        try{
           List<Book> bookList = bookService.getAllBooks();
           return ResponseEntity.ok(bookList);
        }catch(Exception E){
            return ResponseEntity.status(400).body(null);
        }

    }

    @PostMapping("/save-book")
    public ResponseEntity<String> saveBook(@RequestBody Book book){
        try{
            book.setUpdatedAt(LocalDateTime.now());
            book.setCreatedAt(LocalDateTime.now());
            System.out.println(book);
            bookService.saveNewBook(book);
            return ResponseEntity.ok("Book saved successfully");
        }catch(Exception E){
            return ResponseEntity.status(400).body(E.getMessage());
        }
    }


    @GetMapping("/books/{id}")
    public ResponseEntity<List<Book>> getBookById(@PathVariable int id){
        try{
            Book book = bookService.getBookById(id);
            List list = List.of(book);
            System.out.println(list);
            return ResponseEntity.ok(list);
        }
        catch(Exception E){
            return ResponseEntity.status(400).body(null);
        }
    }


    @PutMapping("update-book/{id}")
    public ResponseEntity<String> updateBookInfo(@PathVariable int id, @RequestBody Book book){
        try{
            bookService.updateBookById(id, book);
            return ResponseEntity.ok("Book updated successfully");
        }
        catch(Exception E){
            return ResponseEntity.status(400).body("Failed to update book");
        }
    }

}
