package com.altindag.hobbyproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private int quantity;
    private BigDecimal price;

    public void setName(String name) {
        this.name = name.toUpperCase().charAt(0) + name.substring(1);
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
