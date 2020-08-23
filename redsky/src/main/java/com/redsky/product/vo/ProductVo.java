package com.redsky.product.vo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class ProductVo {
    @Id
    private int productId;
    private String productName;

    public int getId() {
        return productId;
    }

    public void setId(int id) {
        this.productId = id;
    }

    public String getName() {
        return productName;
    }

    public void setName(String name) {
        this.productName = name;
    }
}
