package com.altindag.hobbyproject.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private String id;
    private String name;
    private String lastname;
    private String email;
    private int age;
    private BigDecimal balance;
}