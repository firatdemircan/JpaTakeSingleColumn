package com.somecolumdata.service;

import com.somecolumdata.dto.BookDTO;
import com.somecolumdata.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    BookDTO addBook(BookDTO book);

    List<BookDTO> getBooks();

    BookDTO getBookById(int id);

    List<Book> getTitles();
}
