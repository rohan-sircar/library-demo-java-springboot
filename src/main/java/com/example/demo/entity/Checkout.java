package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "checkouts")

public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int checkoutId;
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @OneToOne
    @JoinColumn(name = "taken_by")
    private User takenBy;
    private LocalDateTime returnTime;
}
