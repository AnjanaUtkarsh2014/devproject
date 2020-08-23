package com.redsky.product.controller.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class ProductDto {

    @Min(value = 0, message = "Product id can not be -ve")
    private int product_id;

    @NotEmpty(message = "Currency code can not be blank")
    private String product_name;

    public int getId() {
        return product_id;
    }

    public void setId(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return product_name;
    }

    public void setName(String product_name) {
        this.product_name = product_name;
    }
}
