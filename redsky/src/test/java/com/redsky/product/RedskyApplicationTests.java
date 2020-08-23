package com.redsky.product;

import com.redsky.product.controller.dto.ProductDto;
import com.redsky.product.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class RedskyApplicationTests {
    @Autowired
    ProductServiceImpl productService;

    @Test
    void testGetProductApi() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8082/product/{id}", HttpMethod.GET, null, String.class, "13860428");
        Assert.notNull(response);
        assertEquals("The Big Lebowski (Blu-ray) (Widescreen)", response.getBody());

    }

    @Test
    public void getProduct() {
        ProductDto str = productService.getProduct(13860428);
        assertEquals("The Big Lebowski (Blu-ray) (Widescreen)", str.getName());
    }

}
