package com.cjhetzle.hsb.service;

import com.cjhetzle.hsb.entity.Product;
import com.cjhetzle.hsb.lib.common.LoggingLayer;
import com.cjhetzle.hsb.repository.KvpRepository;
import com.cjhetzle.hsb.repository.ProductRepository;
import com.cjhetzle.hsb.rest.PaypalRestClient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class CatalogueService extends LoggingLayer {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    KvpRepository kvpRepository;
    PaypalRestClient restClient = new PaypalRestClient();

    public Product createProduct(Product product) {
        Long entryTime = entering("createProduct", product);
        info("Creating RestConnection");

        PaypalRestClient.build(kvpRepository);
        restClient.createConnection();
        info("Posting product to PayPal.");
        restClient.createProduct(product);
        exiting("createProduct", entryTime);
        return productRepository.save(product);
    }

    public List<Product> findProductByName(String name) {
        entering("findProduct");
        return productRepository.findAllByName(name);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
