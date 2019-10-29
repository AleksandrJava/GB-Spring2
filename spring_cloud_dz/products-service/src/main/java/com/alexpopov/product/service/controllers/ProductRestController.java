package com.alexpopov.product.service.controllers;

import com.alexpopov.product.service.entities.Product;
import com.alexpopov.product.service.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import products.ProductDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/v1/products")
public class ProductRestController {

    private ProductService productsService;

    @Autowired
    public void setProductsService(ProductService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/showAll")
    public List<ProductDTO> showProducts(){
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : productsService.getProducts()) {
            System.out.println(product);
            productDTOS.add(new ProductDTO(product.getId(), product.getTitle(), product.getPrice()));
        }
        return productDTOS;
    }

//    @GetMapping("/{id}") //http://localhost:9873/rest/v1/products/2
//    @ResponseStatus(HttpStatus.OK)
//    public Product showProductById(@PathVariable(name = "id") Long id){
//        Product product = productsService.findById(id);
//        return product;
//    }

}