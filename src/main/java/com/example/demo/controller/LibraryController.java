package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.BooksStore;
import com.example.demo.model.CheckoutDTO;
import com.example.demo.model.CheckoutResultDTO;
import com.example.demo.model.CreateBookDTO;
import com.example.demo.model.DiscontinueBookDTO;
import com.example.demo.model.ExtendTimeDTO;
import com.example.demo.model.ReturnBookDTO;
import com.example.demo.service.BookSearchMode;
import com.example.demo.service.LibraryService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/library")
@RequiredArgsConstructor
public class LibraryController {
    private final LibraryService libraryService;

    @GetMapping("/books/get/all")
    List<BooksStore> getAllBooks() {
        return libraryService.getAllBooks();
    }

    @GetMapping("/books/get")
    Optional<BooksStore> getBookByParam(@RequestParam BookSearchMode mode, @RequestParam String value) {
        return libraryService.getBookByParam(mode, value);
    }

    @PostMapping("/checkout")
    Optional<CheckoutResultDTO> checkoutBook(@RequestBody CheckoutDTO dto) {
        final var mbCheckoutId = libraryService.checkoutBook(dto.getBookId(), dto.getUserId());
        return mbCheckoutId.map(checkoutId -> {
            final var result = new CheckoutResultDTO();
            result.setCheckoutId(checkoutId);
            return result;
        });
    }

    @PostMapping("/return-book")
    void returnBook(@RequestBody ReturnBookDTO dto) {
        libraryService.returnBook(dto.getCheckoutId());
    }

    @PostMapping("/books/create")
    BooksStore createBook(@RequestBody CreateBookDTO dto) {
        return libraryService.createBook(dto);
    }

    @PostMapping("/extend-time")
    void extendTime(@RequestBody ExtendTimeDTO dto) {
        libraryService.extendReturnTime(dto);
    }

    @PostMapping("/books/discontinue")
    void discontinueBook(@RequestBody DiscontinueBookDTO dto) {
        libraryService.discontinueBook(dto.getBookId());
    }
}
