package com.altindag.hobbyproject.domain;


//import jakarta.persistence.Column;
//import jakarta.persistence.SequenceGenerator;
//
//import static jakarta.persistence.GenerationType.SEQUENCE;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private int balance;

    public void setName(String name) {
        this.name = name.toUpperCase().charAt(0) + name.substring(1);
    }
}
