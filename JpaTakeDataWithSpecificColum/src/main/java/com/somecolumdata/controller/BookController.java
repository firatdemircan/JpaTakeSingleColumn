package com.somecolumdata.controller;

import com.somecolumdata.dto.BookDTO;
import com.somecolumdata.models.Book;
import com.somecolumdata.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/insert")
    public ResponseEntity<Object> insert(@RequestBody BookDTO book) {
        Map<String, Object> hm = new HashMap<String, Object>();
        BookDTO b = bookService.addBook(book);
        hm.put("status",true);

        hm.put("Book",b);

        return new ResponseEntity(hm, HttpStatus.OK);

    }

    @GetMapping("/list")
    public ResponseEntity<Object> list() {
        Map<String, Object> hm = new HashMap<String, Object>();
        List<BookDTO> books = bookService.getBooks();
        hm.put("status",true);
        hm.put("Books",books);

        return new ResponseEntity(hm, HttpStatus.OK);

    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Object> getById(@PathVariable int id) {
        Map<String, Object> hm = new HashMap<String, Object>();
        BookDTO book = bookService.getBookById(id);
        hm.put("status",true);
        hm.put("Books",book);

        return new ResponseEntity(hm, HttpStatus.OK);

    }

    @GetMapping("/getTitles")
    public ResponseEntity<Object> getTitles(){
        Map<String,Object> hm = new HashMap<>();

        List<Book> books = bookService.getTitles();

        hm.put("status",true);
        hm.put("data",books);
        return new ResponseEntity(hm,HttpStatus.OK);
    }


}
