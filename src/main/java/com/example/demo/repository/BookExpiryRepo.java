package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.entity.BookExpiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookExpiryRepo extends JpaRepository<BookExpiry, Integer> {
    // @Modifying
    // @Query("update BookExpiry be join fetch be.book book set be.discontinued = ?2
    // where book.id = ?1")
    // void updateBookDiscontinueStatus(int bookId, boolean discontinue);
    @Query("select be from BookExpiry be join fetch be.book book where book.bookId = ?1")
    Optional<BookExpiry> findByBookId(int bookId);
}
