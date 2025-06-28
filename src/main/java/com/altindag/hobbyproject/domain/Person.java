package com.altindag.hobbyproject.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "persons")
public class Person{

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

    public void setBalance(BigDecimal balance){
        this.balance = balance;
    }
}
