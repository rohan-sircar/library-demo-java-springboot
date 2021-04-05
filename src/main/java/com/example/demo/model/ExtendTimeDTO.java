package com.example.demo.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExtendTimeDTO {
    private int checkoutId;
    private LocalDateTime newDate;
}
