package com.revature.services;


import com.revature.models.Book;
import com.revature.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Predicate;

@Service
public class BookService {
    private final BookRepo bookRepo;
    private final AuthorService authorService;

    @Autowired
    public BookService(BookRepo bookRepo, AuthorService authorService) {
        this.bookRepo = bookRepo;
        this.authorService = authorService;
    }

    public List<Book> getAllBooks() {
        List<Book> books = bookRepo.findAll();
        return books;
    }

    @Transactional
    public Book insertBook(Book book) {
        return bookRepo.save(book);
    }

    public Book getBookById(int id) {
        Book book = null;
        try {
            book = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Provided id does not match any book in the database"));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return book;
    }

    public List<Book> getBooksByAuthorId(int id) {
        List<Book> books = bookRepo.findAllByAuthorId(id);
        if (books.isEmpty()) return null;
        return books;
    }

    public boolean isBookInStock(int id) {
        try {
            Book book = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Provided id does not match any book in the database"));
            return book.getIsStocked();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Book updateInStock(int id) {
        try {
            Book updatedBook = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Provided id does not match any book in the database"));
            updatedBook.setIsStocked(!updatedBook.getIsStocked());
            return bookRepo.save(updatedBook);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
