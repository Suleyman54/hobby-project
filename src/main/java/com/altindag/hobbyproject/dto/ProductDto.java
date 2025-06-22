package com.altindag.hobbyproject.dto;

import java.math.BigDecimal;

public record ProductDto(Long id, String name, int quantity, BigDecimal price) {
}
