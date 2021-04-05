package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.BooksStore;
import com.example.demo.model.CreateBookDTO;
import com.example.demo.model.ExtendTimeDTO;

import org.springframework.stereotype.Service;

@Service
public interface LibraryService {
    public List<BooksStore> getAllBooks();

    public Optional<BooksStore> getBookByParam(BookSearchMode mode, String value);

    public Optional<Integer> checkoutBook(int bookId, int userId);

    public void returnBook(int checkoutId);

    public BooksStore createBook(CreateBookDTO dto);

    public void extendReturnTime(ExtendTimeDTO dto);

    public void discontinueBook(int bookId);
}
