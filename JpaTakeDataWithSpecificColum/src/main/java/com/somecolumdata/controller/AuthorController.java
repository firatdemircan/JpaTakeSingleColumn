package com.somecolumdata.controller;

import com.somecolumdata.models.Author;
import com.somecolumdata.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/author")
public class AuthorController {

    AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @PostMapping("/insert")
    public ResponseEntity<Object> insert(@RequestBody Author author) {
        Map<String, Object> hm = new HashMap<String, Object>();
        Author b = authorService.addAuthor(author);
        hm.put("status",true);

        hm.put("Author",b);

        return new ResponseEntity(hm, HttpStatus.OK);

    }

    @GetMapping("/list")
    public ResponseEntity<Object> list() {
        Map<String, Object> hm = new HashMap<String, Object>();
        List<Author> authors = authorService.getAuthors();
        hm.put("status",true);
        hm.put("authors",authors);

        return new ResponseEntity(hm, HttpStatus.OK);

    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Object> getById(@PathVariable int id) {
        Map<String, Object> hm = new HashMap<String, Object>();
        Author author = authorService.getAuthorById(id);
        hm.put("status",true);
        hm.put("Book",author);

        return new ResponseEntity(hm, HttpStatus.OK);

    }

}
