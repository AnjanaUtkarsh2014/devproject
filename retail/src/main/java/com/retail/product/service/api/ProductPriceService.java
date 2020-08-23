package com.retail.product.service.api;

import com.retail.product.controller.dto.ProductPriceDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductPriceService {
    String saveProductPrice(List<ProductPriceDto> productPriceDtoList);

    String updateProductPrice(ProductPriceDto productPriceDto);

    ProductPriceDto getProductPrice(Integer id);
}
