package com.example.demo.repository;

import com.example.demo.entity.BookExpiry;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookExpiryRepo extends JpaRepository<BookExpiry, Integer> {

}
