package com.altindag.hobbyproject.controller;

import com.altindag.hobbyproject.dto.ProductDto;
import com.altindag.hobbyproject.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductDto> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/addProduct")
    public void addProduct(@Valid @RequestBody ProductDto productDto) {
        productService.addProduct(productDto);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable String id,
            @RequestBody ProductDto productDto) {
        ProductDto updateProduct = productService.updateProduct(id, productDto);
        return ResponseEntity.ok(updateProduct);
    }
}
