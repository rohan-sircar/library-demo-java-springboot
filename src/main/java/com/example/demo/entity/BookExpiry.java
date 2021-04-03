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
public class BookExpiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int bookExpiryId;
    // @OneToMany(mappedBy = "book_id")
    // List<Book> book;
    @OneToOne
    @JoinColumn(name = "book_id")
    Book book;
    boolean discontinued;

}
