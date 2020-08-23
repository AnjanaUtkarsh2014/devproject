package com.redsky.product.controller.impl;

import com.redsky.product.controller.api.ProductRestful;
import com.redsky.product.controller.dto.ProductDto;
import com.redsky.product.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class ProductRestfulImpl implements ProductRestful {
    @Autowired
    ProductServiceImpl productService;

    /**
     * This method will get product name for given product id
     *
     * @param productId
     * @return String
     */
    @Override
    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable(value = "id") Integer productId) {
        ProductDto productDto = productService.getProduct(productId);
        return productDto.getName();
    }

    /**
     * This method will save product name
     *
     * @param product
     * @return String
     */
    @Override
    @PostMapping("/product")
    public String saveProduct(@RequestBody List<ProductDto> product) {
        return productService.saveProduct(product);

    }
}
