package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.BooksStore;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookExpiryRepo;
import com.example.demo.repository.BooksRepository;
import com.example.demo.repository.BooksStoreRepo;
import com.example.demo.repository.CheckoutsRepo;
import com.example.demo.repository.UsersRepo;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LibraryService {
    private final BooksRepository booksRepository;
    private final AuthorRepository authorRepository;
    private final BookExpiryRepo bookExpiryRepo;
    private final CheckoutsRepo checkoutsRepo;
    private final UsersRepo usersRepo;
    private final BooksStoreRepo booksStoreRepo;

    // void blah() {
    // System.out.println("blah");
    // }

    public List<BooksStore> getAllBooks() {
        return booksStoreRepo.findAll();
    }
}
