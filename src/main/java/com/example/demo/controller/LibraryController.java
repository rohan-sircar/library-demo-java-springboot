package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.BooksStore;
import com.example.demo.service.LibraryService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/library")
@RequiredArgsConstructor
public class LibraryController {
    private final LibraryService libraryService;

    List<BooksStore> getAllBooks() {
        return libraryService.getAllBooks();
    }
}
