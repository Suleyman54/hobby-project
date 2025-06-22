package com.altindag.hobbyproject.dto;

import java.math.BigDecimal;

public record PersonDto(Long id, String name, String lastname, String email, int age, BigDecimal balance) {
}
