package com.redsky.product;

import com.redsky.product.controller.dto.ProductDto;
import com.redsky.product.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class RedskyApplicationTests {
    @Autowired
    ProductServiceImpl productService;

    @BeforeAll
    public static void setUp() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        List<ProductDto> productDtoList = new ArrayList<>();
        ProductDto productDto = new ProductDto();
        productDto.setId(13860428);
        productDto.setName("The Big Lebowski (Blu-ray) (Widescreen)");
        productDtoList.add(productDto);
        restTemplate.postForEntity("http://localhost:8082/product", productDtoList, String.class);

    }

    @Test
    void testGetProductApi() {
        ProductDto productDto = productService.getProduct(13860428);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8082/product/{id}", HttpMethod.GET, null, String.class, "13860428");
        Assert.notNull(response);
        assertEquals(productDto.getName(), response.getBody());

    }
}
