package com.retail.product.controller.api;

import com.retail.product.controller.dto.ProductDetailsDto;
import com.retail.product.controller.dto.ProductPriceDto;

import java.util.List;


public interface RetailProductRestful {
    ProductDetailsDto getProductDetails(Integer productId);

    String saveProduct(List<ProductPriceDto> productPriceDtoList);

    String updateProductPrice(Integer productId, ProductPriceDto productPriceDto);

}
