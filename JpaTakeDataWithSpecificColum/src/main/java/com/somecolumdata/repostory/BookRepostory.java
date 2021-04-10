package com.somecolumdata.repostory;

import com.somecolumdata.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepostory extends JpaRepository<Book,Integer> {

    @Query("select new Book(b.title) from Book b")
    List<Book> getTitles();
}
