package com.retail.product.controller.dto;

public class ProductDetailsDto {
    private int productId;
    private String productName;
    private ProductPriceDto productPriceDto;

    public int getId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductPriceDto getCurrent_price() {
        return productPriceDto;
    }

    public void setCurrent_price(ProductPriceDto productPriceDto) {
        this.productPriceDto = productPriceDto;
    }
}
