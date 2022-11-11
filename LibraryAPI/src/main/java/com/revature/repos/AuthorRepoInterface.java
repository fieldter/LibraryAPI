package com.revature.repos;

import com.revature.models.Author;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepoInterface {

    public Author getAuthorById(int id);



}

