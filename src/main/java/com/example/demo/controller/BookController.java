package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.services.BookService;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/book")
@Tag(name = "Book", description = "Book management APIs")
public class BookController {

  private final BookService bookService;
  @Autowired
  public BookController(BookService bookService){
    this.bookService = bookService;
  }

  @GetMapping
  public ResponseEntity<List<Book>> getAllBooks(){
    List<Book> allBooks = bookService.getAllBooks();
    return ResponseEntity.ok(allBooks);
   }


   @GetMapping("{id}")
   public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
     Book book = bookService.getBookById(id);
     return ResponseEntity.ok(book);
   }


   @DeleteMapping("{id}")
   public ResponseEntity<Void> deleteById(@PathVariable Integer id){
    boolean isDeleted = bookService.deleteById(id);
    if(isDeleted){
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
   }
 
  @PostMapping("/add-book")
  @Operation(summary = "Add a new book", description = "Creates a new book in the system")
  @ApiResponse(responseCode = "200", description = "Book successfully created")
  public ResponseEntity<Book> addBook(@RequestBody Book book){
   System.out.println("book payload: " + book);
   Book savedBook = bookService.addBook(book);
   return ResponseEntity.ok(savedBook);
  }
}
