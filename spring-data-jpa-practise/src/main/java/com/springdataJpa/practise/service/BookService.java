package com.springdataJpa.practise.service;

import com.springdataJpa.practise.entity.Book;
import com.springdataJpa.practise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookService {
    private List<Book> bookList;
    private Book book;

    @Autowired
    private BookRepository bookRepo;
    public List<Book> getAllBooks(){
        bookList = bookRepo.findAll();
        return bookList;
    }

    public void saveNewBook(Book book){
        Book bookEntity = bookRepo.save(book);
        System.out.println(bookEntity);
    }

    public Book getBookById(int id){
        book = bookRepo.findById(id).get();
        return book;
    }


    public void updateBookById(int id, Book bookInst){
        book = bookRepo.findById(id).get();
        book = bookInst;
        book.setCreatedAt(LocalDateTime.now());
        bookRepo.save(book);
    }

    public void deleteBookById(int id){
        bookRepo.deleteById(id);
    }
}
