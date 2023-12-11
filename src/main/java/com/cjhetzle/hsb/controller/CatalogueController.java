package com.cjhetzle.hsb.controller;

import com.cjhetzle.hsb.entity.Product;
import com.cjhetzle.hsb.entity.json.ProductDto;
import com.cjhetzle.hsb.lib.common.LoggingLayer;
import com.cjhetzle.hsb.service.CatalogueService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalogue")
public class CatalogueController extends LoggingLayer {
    private Logger logger = LoggerFactory.getLogger(CatalogueController.class);

    @Autowired
    private CatalogueService service;

    @PostMapping
    public String createProduct(@RequestBody final Product product) {
        entering("entering createProduct...", product);

        service.createProduct(product);
        String jsonResponse = "failed to parse.";
        try {
            jsonResponse = new ObjectMapper()
                    .writeValueAsString(ProductDto.fromEntity(product));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonResponse;
    }

    @GetMapping("/")
    public List<Product> getProduct(@PathVariable String name) {
        logger.trace("entering getProduct...");

        return service.findProductByName(name);
    }
    
    @GetMapping
    public List<Product> getProducts() {
        logger.trace("entering getProducts...");

        return service.findAllProducts();
    }

}
