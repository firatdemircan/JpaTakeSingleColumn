package com.somecolumdata.repostory;

import com.somecolumdata.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepostory extends JpaRepository<Author,Integer> {
}
