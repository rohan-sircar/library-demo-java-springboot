package com.example.demo.repository;

import com.example.demo.entity.BooksStore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksStoreRepo extends JpaRepository<BooksStore, Integer> {

}
