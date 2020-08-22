package com.redsky.product.controller.api;

import com.redsky.product.modal.ProductDetails;
import com.redsky.product.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ProductRestful {

    List<ProductDetails> getProductDetails();
}
