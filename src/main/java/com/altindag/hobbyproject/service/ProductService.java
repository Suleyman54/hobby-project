package com.altindag.hobbyproject.service;

import com.altindag.hobbyproject.domain.Product;
import com.altindag.hobbyproject.dto.ProductDto;
import com.altindag.hobbyproject.mapper.ProductMapper;
import com.altindag.hobbyproject.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDto> getProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::mapToProductDto)
                .toList();
    }

    public ProductDto addProduct(ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        product = productRepository.save(product);
        return productMapper.mapToProductDto(product);
    }


    public void deleteProduct(String id) {
        if (productRepository.existsById(id)){
            throw new IllegalStateException(String.
                    format("Product with this id: %s does not exists", id));
        }
        productRepository.deleteById(id);
    }

    public ProductDto updateProduct(String id, ProductDto productDto) {
        Product product = productRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        String.format("Product with id: %s does not exist", id)));

        product.setPrice(productDto.price());

        return productMapper.mapToProductDto(productRepository.save(product));
    }
}
