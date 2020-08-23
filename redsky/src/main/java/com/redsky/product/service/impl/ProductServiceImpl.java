package com.redsky.product.service.impl;

import com.redsky.product.constant.RedSkyConstant;
import com.redsky.product.controller.dto.ProductDto;
import com.redsky.product.repository.ProductRepository;
import com.redsky.product.service.api.ProductService;
import com.redsky.product.vo.ProductVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    /**
     * This method will get product name
     *
     * @param productId
     * @return ProductDto
     */
    @Override
    public ProductDto getProduct(Integer productId) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(productRepository.findById(productId).get(), productDto);
        return productDto;
    }

    /**
     * This method will save product name
     *
     * @param productDtoList
     */
    @Override
    public String saveProduct(List<ProductDto> productDtoList) {
        List<ProductVo> productVoList = new ArrayList<>();
        for (ProductDto productDtoObj : productDtoList) {
            ProductVo productVo = new ProductVo();
            BeanUtils.copyProperties(productDtoObj, productVo);
            productVoList.add(productVo);
        }
        productRepository.saveAll(productVoList);
        return RedSkyConstant.SUCCESS;
    }
}
