package com.alexpopov.front.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import products.ProductDTO;

import java.util.ArrayList;


@Controller
public class ProductController {
    private ProductClient productClient;

    @Autowired
    public void setProductClient(ProductClient productClient) {
        this.productClient = productClient;
    }

    @RequestMapping("/show")
    public String showAll(Model model) {
        ArrayList<ProductDTO> answer = productClient.showAll();

        model.addAttribute("products", answer);

        return "products-view";
    }
}
