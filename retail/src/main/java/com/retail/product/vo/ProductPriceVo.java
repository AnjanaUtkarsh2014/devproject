package com.retail.product.vo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productprice")
public class ProductPriceVo {
    @Id
    private int productId;
    private int currentPrice;
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

