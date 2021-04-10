package com.somecolumdata.dto;

import com.somecolumdata.models.Author;
import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private int bid;
    private String title;
    private String description;

    @NotNull
    private int authorID;
}
