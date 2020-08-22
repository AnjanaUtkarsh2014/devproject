package com.redsky.product.controller.impl;

import com.redsky.product.controller.api.ProductRestful;
import com.redsky.product.modal.ProductDetails;
import com.redsky.product.service.api.ProductService;
import com.redsky.product.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestfulmpl implements ProductRestful {
    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/test")
    public List<ProductDetails> getProductDetails(){
        return productService.getProductDetails();
    }

}
