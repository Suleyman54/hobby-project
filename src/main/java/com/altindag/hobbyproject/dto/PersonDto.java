package com.altindag.hobbyproject.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

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