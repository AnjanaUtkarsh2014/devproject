package com.retail.product.controller.impl;

import com.retail.product.client.api.ProductPriceClientService;
import com.retail.product.controller.api.RetailProductRestful;
import com.retail.product.controller.dto.ProductCurrentPriceDto;
import com.retail.product.controller.dto.ProductDetailsDto;
import com.retail.product.controller.dto.ProductPriceDto;
import com.retail.product.service.api.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RetailProductRestfulImpl implements RetailProductRestful {
    @Autowired
    ProductPriceService productPriceService;
    @Autowired
    ProductPriceClientService productPriceClientService;

    /**
     * This method will get product details like product id, name, price and currency code
     *
     * @param productId
     * @return product details
     */
    @GetMapping("/products/{id}")
    @Override
    public ProductDetailsDto getProductDetails(@PathVariable(name = "id") Integer productId) {
        ProductDetailsDto productDetailsDto = new ProductDetailsDto();
        //get product price details
        ProductPriceDto productPriceDto = productPriceService.getProductPrice(productId);
        ProductCurrentPriceDto productCurrentPriceDto=new ProductCurrentPriceDto();
        productCurrentPriceDto.setCurrency_code(productPriceDto.getCurrency_code());
        productCurrentPriceDto.setValue(productPriceDto.getValue());
        //call product name from redsky
        String productName = productPriceClientService.getProductName(productId);
        //forming response
        productDetailsDto.setId(productId);
        productDetailsDto.setName(productName);
        productDetailsDto.setCurrent_price(productCurrentPriceDto);
        return productDetailsDto;
    }

    /**
     * This method will save the product price and currency code
     *
     * @param productPriceDtoList
     * @return string
     */
    @PostMapping("/products")
    @Override
    public String saveProduct(@RequestBody List<ProductPriceDto> productPriceDtoList) {
        return productPriceService.saveProductPrice(productPriceDtoList);
    }

    /**
     * This method will update product's price
     *
     * @param productId * @return
     */
    @PutMapping("/products/{id}")
    @Override
    public String updateProductPrice(@PathVariable(value = "id") Integer productId, @RequestBody @Valid ProductPriceDto productPriceDto) {
        if (productId != productPriceDto.getId())
            return "Product id is not same.";
        productPriceService.getProductPrice(productId);
        return productPriceService.updateProductPrice(productPriceDto);
    }
}