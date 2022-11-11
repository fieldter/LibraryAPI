package com.revature.repos;

import com.revature.models.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepoInterface {

    public List<Book> getAllBooks();

    public Book insertBook(Book b);

    public Book getBookById(int id);

    public List<Book> getBooksByAuthorId(int id);

}

