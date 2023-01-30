package com.example.WAA_Assignment1.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class LogDto {
    long id;
    private String principal;
    private String operation;
    private String endPoint;
    private String method;
    private LocalDateTime requestTime;
}
