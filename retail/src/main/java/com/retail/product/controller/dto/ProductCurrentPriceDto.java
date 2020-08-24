package com.retail.product.controller.dto;

public class ProductCurrentPriceDto {
    private int currentPrice;
    private String currencyCode;

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
