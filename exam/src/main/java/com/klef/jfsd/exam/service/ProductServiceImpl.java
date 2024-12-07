package com.klef.jfsd.exam.service;

import com.klef.jfsd.exam.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    
    private static final String FAKE_STORE_API_URL = "https://fakestoreapi.com/products";
    private final RestTemplate restTemplate;

    public ProductServiceImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<Product> getAllProducts() {
        Product[] products = restTemplate.getForObject(FAKE_STORE_API_URL, Product[].class);
        return Arrays.asList(products);
    }
}