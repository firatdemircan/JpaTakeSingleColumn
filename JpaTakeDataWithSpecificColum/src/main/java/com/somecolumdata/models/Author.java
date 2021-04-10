package com.somecolumdata.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;

    private String name;
    private String surname;


    @OneToMany(mappedBy="author")
    @JsonBackReference
    private Set<Book> books;

}
