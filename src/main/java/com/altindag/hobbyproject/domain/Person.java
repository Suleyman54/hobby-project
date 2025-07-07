package com.altindag.hobbyproject.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotBlank
    private String email;
    @Min(14)
    private int age;
    private BigDecimal balance;

}