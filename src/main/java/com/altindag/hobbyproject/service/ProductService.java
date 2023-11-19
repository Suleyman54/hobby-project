package com.altindag.hobbyproject.service;

import com.altindag.hobbyproject.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    public List<Product> getProducts() {
        return List.of(
                new Product(
                        "Iphone 10",
                        800));
    }
}
