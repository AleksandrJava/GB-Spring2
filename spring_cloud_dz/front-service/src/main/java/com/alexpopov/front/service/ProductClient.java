package com.alexpopov.front.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import products.ProductDTO;

import java.util.ArrayList;

@FeignClient("products-service")
public interface ProductClient {
    @RequestMapping("/rest/products/showAll")
    ArrayList<ProductDTO> showAll();
}
