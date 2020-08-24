package com.retail.product.controller.dto;

public class ProductDetailsDto {
    private int productId;
    private String productName;
    private ProductCurrentPriceDto productCurrentPriceDto;

    public int getId() {
        return productId;
    }

    public void setId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return productName;
    }

    public void setName(String productName) {
        this.productName = productName;
    }

    public ProductCurrentPriceDto getCurrent_price() {
        return productCurrentPriceDto;
    }

    public void setCurrent_price(ProductCurrentPriceDto productCurrentPriceDto) {
        this.productCurrentPriceDto = productCurrentPriceDto;
    }
}
