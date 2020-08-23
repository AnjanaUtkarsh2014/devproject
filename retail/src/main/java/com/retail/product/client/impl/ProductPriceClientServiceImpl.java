package com.retail.product.client.impl;

import com.retail.product.client.api.ProductPriceClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductPriceClientServiceImpl implements ProductPriceClientService {
    @Value("${redsky.url}")
    private String redskyUrl;

    @Override
    public String getProductName(Integer productId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(redskyUrl, HttpMethod.GET, null, String.class, productId);
        if (response != null) {
            return response.getBody();
        }
        return null;
    }
}
