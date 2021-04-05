package com.example.demo.model;

import lombok.Data;

@Data
public class CreateBookDTO {
    private String isbn;
    private String bookName;
    private int authorId;
    private int quantity;
}
