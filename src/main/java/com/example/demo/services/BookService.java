package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    public Book addBook(Book book){
       return bookRepository.save(book);
    }
  


    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public boolean deleteById(Integer id) {
        if (bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Book getBookById(Integer id){
        Book foundBook = bookRepository.findById(id).orElse(null);
        return foundBook;
    }

}
