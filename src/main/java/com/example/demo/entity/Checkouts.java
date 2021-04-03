package com.example.demo.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Checkouts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int checkoutId;
    @OneToOne
    @JoinColumn(name = "book_id")
    Book book;
    @OneToOne
    @JoinColumn(name = "taken_by")
    User takenBy;
    Instant returnTime;
}
