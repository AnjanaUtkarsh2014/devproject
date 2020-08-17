package com.redsky.product.service.impl;

import com.redsky.product.modal.ProductDetails;
import com.redsky.product.repository.ProductRepository;
import com.redsky.product.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<ProductDetails> getProductDetails() {
        return productRepository.findAll();
    }
}
