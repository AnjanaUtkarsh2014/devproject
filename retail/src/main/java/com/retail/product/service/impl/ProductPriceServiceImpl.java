package com.retail.product.service.impl;

import com.retail.product.controller.dto.ProductPriceDto;
import com.retail.product.repository.ProductPriceRepository;
import com.retail.product.service.api.ProductPriceService;
import com.retail.product.vo.ProductPriceVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductPriceServiceImpl implements ProductPriceService {
    private static String SUCCESS = "success";
    @Autowired
    ProductPriceRepository productPriceRepository;

    /**
     * This method will save product price
     *
     * @param productPriceDtoList
     */
    @Override
    public String saveProductPrice(List<ProductPriceDto> productPriceDtoList) {
        List<ProductPriceVo> productPriceVoList = new ArrayList<>();
        for (ProductPriceDto productPriceDtoObj : productPriceDtoList) {
            ProductPriceVo productPriceVo = new ProductPriceVo();
            BeanUtils.copyProperties(productPriceDtoObj, productPriceVo);
            productPriceVoList.add(productPriceVo);
        }
        productPriceRepository.saveAll(productPriceVoList);
        return SUCCESS;
    }

    @Override
    public String updateProductPrice(ProductPriceDto productPriceDto) {
        ProductPriceVo productPriceVo = new ProductPriceVo();
        BeanUtils.copyProperties(productPriceDto, productPriceVo);
        productPriceRepository.save(productPriceVo);
        return SUCCESS;
    }

    /**
     * This method will fetch product price based on product id
     *
     * @param productId
     * @return ProductPriceDto
     */
    @Override
    public ProductPriceDto getProductPrice(Integer productId) {
        ProductPriceDto productPriceDto = new ProductPriceDto();
        ProductPriceVo productPriceVo = productPriceRepository.findById(productId).get();
        BeanUtils.copyProperties(productPriceVo, productPriceDto);
        return productPriceDto;
    }
}
