package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.entity.BooksStore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksStoreRepo extends JpaRepository<BooksStore, Integer> {
    @Query("select bs from BooksStore bs join fetch bs.book b where b.bookName = ?1 ")
    public Optional<BooksStore> getBookByName(String bookName);

    @Query("select bs from BooksStore bs join fetch bs.book b join fetch b.author a where  a.authorName = ?1")
    public Optional<BooksStore> getBookByAuthorName(String authorName);

    @Modifying
    @Query("update BooksStore bs set bs.quantity = ?2 where bs.booksStoreId = ?1")
    public void updateQuantity(int bookId, int quantity);
}
