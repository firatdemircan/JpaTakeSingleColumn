package com.somecolumdata.service.serviceImpl;

import com.somecolumdata.dto.BookDTO;
import com.somecolumdata.models.Author;
import com.somecolumdata.models.Book;
import com.somecolumdata.repostory.AuthorRepostory;
import com.somecolumdata.repostory.BookRepostory;
import com.somecolumdata.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    BookRepostory bookRepostory;
    AuthorRepostory authorResoptory;

    public BookServiceImpl(BookRepostory bookRepostory, AuthorRepostory authorResoptory) {
        this.bookRepostory = bookRepostory;
        this.authorResoptory = authorResoptory;
    }


    @Override
    public BookDTO addBook(BookDTO book) {
        Book b = new Book();
        b.setTitle(book.getTitle());
        b.setDescription(book.getDescription());

        Author author = authorResoptory.getOne(book.getAuthorID());

        if(author!=null){
            b.setAuthor(author);
            bookRepostory.save(b);
            return book;
        }

        return null;
    }

    @Override
    public List<BookDTO> getBooks() {
        List<Book> books = bookRepostory.findAll();
        List<BookDTO> bookDTOS = new ArrayList<BookDTO>();
        for (Book book : books) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setBid(book.getBid());
            bookDTO.setTitle(book.getTitle());
            bookDTO.setDescription(book.getDescription());
            bookDTO.setAuthorID(book.getAuthor().getAid());

            bookDTOS.add(bookDTO);
        }

        return bookDTOS;
    }

    @Override
    public BookDTO getBookById(int id) {
        Book b = bookRepostory.getOne(id);
        BookDTO bookDTO = new BookDTO();


        bookDTO.setBid(b.getBid());
        bookDTO.setTitle(b.getTitle());
        bookDTO.setDescription(b.getDescription());
        bookDTO.setAuthorID(b.getAuthor().getAid());

        return bookDTO;
    }

    @Override
    public List<Book> getTitles() {
        List<Book> books = bookRepostory.getTitles();
        return books;
    }
}
