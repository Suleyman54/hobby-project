package com.altindag.hobbyproject.service;

import com.altindag.hobbyproject.domain.Product;
import com.altindag.hobbyproject.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private List<Product> products;
    @Autowired
    ProductRepository productRepository;

    public ProductService(List<Product> products){
        this.products = products;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
//        Long id = product.getId();
//        boolean present = productRepository.existsById(id);
//        if (present){
//            throw new IllegalStateException(String
//                    .format("Product with this id: %s already exists", id));
//        }
        productRepository.save(product);
    }


    public void deleteProduct(Long id) {
        boolean present = productRepository.existsById(id);
        if (!present){
            throw new IllegalStateException(String.
                    format("Product with this id: %s does not exists", id));
        }
        productRepository.deleteById(id);
    }

    @Transactional
    public void updateProduct(Long id, int price) {
        Product product = productRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        String.format("Product with id: %s does not exist", id)));

        product.setPrice(price);
        productRepository.save(product);
    }
}
