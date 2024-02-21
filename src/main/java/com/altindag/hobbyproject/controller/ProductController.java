package com.altindag.hobbyproject.controller;

import com.altindag.hobbyproject.domain.Product;
import com.altindag.hobbyproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    @PutMapping("/updateProduct/{id}")
    public void updateProduct(
            @PathVariable Long id,
            @RequestParam(required = false) int price){
        productService.updateProduct(id, price);
    }
}
