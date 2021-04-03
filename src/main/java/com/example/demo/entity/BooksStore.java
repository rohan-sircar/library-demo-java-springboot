package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class BooksStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int booksStoreId;
    // @OneToMany(mappedBy = "book_id")
    @OneToOne
    @JoinColumn(name = "book_id")
    Book book;
    int quantity;

}
