package com.altindag.hobbyproject.repository;

import com.altindag.hobbyproject.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
