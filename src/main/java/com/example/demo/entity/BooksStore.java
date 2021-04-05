package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class BooksStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int booksStoreId;
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private int quantity;

}
