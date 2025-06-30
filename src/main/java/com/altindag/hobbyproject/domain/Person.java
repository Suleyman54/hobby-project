package com.altindag.hobbyproject.domain;

import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "persons")
public class Person {

    @Id
    private String id;
    private String name;
    private String lastname;
    private String email;
    private int age;
    private BigDecimal balance;

    public void setName(String name) {
        this.name = name.toUpperCase().charAt(0) + name.substring(1);
    }
}