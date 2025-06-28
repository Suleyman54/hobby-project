package com.altindag.hobbyproject.mapper;

import com.altindag.hobbyproject.domain.Product;
import com.altindag.hobbyproject.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto mapToProductDto(Product product);

    Product mapToProduct(ProductDto productDto);
}
