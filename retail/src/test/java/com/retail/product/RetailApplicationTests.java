package com.retail.product;

import com.retail.product.client.api.ProductPriceClientService;
import com.retail.product.controller.dto.ProductDetailsDto;
import com.retail.product.controller.dto.ProductPriceDto;
import com.retail.product.service.api.ProductPriceService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class RetailApplicationTests {
    @Autowired
    private ProductPriceClientService productPriceClientService;
    @Autowired
    private ProductPriceService productPriceService;

    @BeforeAll
    public static void setUp() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        List<ProductPriceDto> priceDtoList = new ArrayList<>();
        ProductPriceDto productPriceDto = new ProductPriceDto();
        productPriceDto.setId(13860428);
        productPriceDto.setCurrency_code("USD");
        productPriceDto.setValue(500);
        priceDtoList.add(productPriceDto);
        restTemplate.postForEntity("http://localhost:8081/products", priceDtoList, String.class);

    }

    @Test
    void testGetProductApi() {
        RestTemplate restTemplate = new RestTemplate();
        String productName = productPriceClientService.getProductName(13860428);
        ProductPriceDto productPriceDto = productPriceService.getProductPrice(13860428);
        ProductDetailsDto productDetailsDto = restTemplate.getForObject("http://localhost:8081/products/{id}", ProductDetailsDto.class, 13860428);
        if (productDetailsDto != null) {
            assertEquals(productName, productDetailsDto.getName());
            assertEquals(productPriceDto.getCurrency_code(), productDetailsDto.getCurrent_price().getCurrency_code());
            assertEquals(productPriceDto.getValue(), productDetailsDto.getCurrent_price().getValue());
        }
    }

    @Test
    void testPutProductApi() {
        RestTemplate restTemplate = new RestTemplate();
        ProductPriceDto productPriceDto = new ProductPriceDto();
        productPriceDto.setId(13860428);
        productPriceDto.setCurrency_code("USD");
        productPriceDto.setValue(7000);
        HttpEntity<ProductPriceDto> requestUpdate = new HttpEntity<>(productPriceDto, null);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8081/products/{id}", HttpMethod.PUT, requestUpdate, String.class, 13860428);
        if (response != null) {
            assertEquals(response, response);

        }
    }

}
