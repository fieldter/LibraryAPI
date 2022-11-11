package com.revature.controllers;

import com.revature.models.Book;
import com.revature.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //This annotation combines @Controller and @ResponseBody
//so this class is now a Bean that can use MVC annotations and send JSON in HTTP Responses
@RequestMapping(value="/books") //all requests ending in /library/books will go to this controller.
@CrossOrigin //This lets us take in HTTP requests from other origins (you may need to configure this later)
public class BookController {

    private BookRepo br;

    @Autowired
    public BookController(BookRepo br){
        super();
        this.br = br;
    }

    //TODO: leave this one implemented for reference?
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {

        List<Book> books = br.getAllBooks();

        if(books != null){
            return ResponseEntity.ok().body(books);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Book> insertNewBook(@RequestBody Book book){
        return null;
    }

    //these two methods have an issue with each other that won't let you compile-----
    //you have to find it :)

    @GetMapping(value="/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        return null;
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<List<Book>> getBooksByAuthorId(@PathVariable int id) {
        return null;
    }

}

