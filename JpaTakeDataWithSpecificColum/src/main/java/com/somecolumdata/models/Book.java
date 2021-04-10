package com.somecolumdata.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    public Book(String title) {
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bid;
    private String title;
    private String description;


    @ManyToOne(optional=true, fetch = FetchType.LAZY)
    @JoinColumn(name="aid")
    @JsonIgnore
    private Author author;
}
