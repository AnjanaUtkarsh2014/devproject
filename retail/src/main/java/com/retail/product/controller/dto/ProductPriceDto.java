package com.retail.product.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class ProductPriceDto {

    @Min(value = 0, message = "Product id can not be -ve")
    private int productId;
    @Min(value = 0, message = "Current price  can not be -ve")
    private int currentPrice;
    @NotEmpty(message = "Currency code can not be blank")
    private String currencyCode;

    public int getId() {
        return productId;
    }

    public void setId(int productId) {
        this.productId = productId;
    }

    public int getValue() {
        return currentPrice;
    }

    public void setValue(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getCurrency_code() {
        return currencyCode;
    }

    public void setCurrency_code(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}
