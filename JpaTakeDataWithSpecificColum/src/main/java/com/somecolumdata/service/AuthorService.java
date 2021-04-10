package com.somecolumdata.service;

import com.somecolumdata.models.Author;
import com.somecolumdata.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

    Author addAuthor(Author author);

    List<Author> getAuthors();

    Author getAuthorById(int id);

}
