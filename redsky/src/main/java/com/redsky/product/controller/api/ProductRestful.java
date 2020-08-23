package com.redsky.product.controller.api;

import com.redsky.product.controller.dto.ProductDto;

import java.util.List;

public interface ProductRestful {

    String getProduct(Integer productId);

    String saveProduct(List<ProductDto> productDto);

}
