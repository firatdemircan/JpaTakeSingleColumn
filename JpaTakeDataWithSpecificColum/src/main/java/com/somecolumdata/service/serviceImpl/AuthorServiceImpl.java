package com.somecolumdata.service.serviceImpl;

import com.somecolumdata.models.Author;
import com.somecolumdata.repostory.AuthorRepostory;
import com.somecolumdata.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    AuthorRepostory authorRepostory;

    public AuthorServiceImpl(AuthorRepostory authorRepostory) {
        this.authorRepostory = authorRepostory;
    }

    @Override
    public Author addAuthor(Author author) {
        return authorRepostory.save(author);
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepostory.findAll();
    }

    @Override
    public Author getAuthorById(int id) {
        return authorRepostory.getOne(id);
    }
}
