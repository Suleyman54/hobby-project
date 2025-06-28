package com.altindag.hobbyproject.dto;

import java.math.BigDecimal;

public record ProductDto(String id, String name, int quantity, BigDecimal price) {
}
