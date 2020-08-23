package com.redsky.product.service.api;

import com.redsky.product.controller.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto getProduct(Integer productId);

    String saveProduct(List<ProductDto> productDtoList);

}
