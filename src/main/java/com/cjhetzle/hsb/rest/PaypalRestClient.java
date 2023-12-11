package com.cjhetzle.hsb.rest;

import com.cjhetzle.hsb.entity.Kvp;
import com.cjhetzle.hsb.entity.Product;
import com.cjhetzle.hsb.entity.json.ProductDto;
import com.cjhetzle.hsb.repository.KvpRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.util.Base64;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClient.ResponseSpec;

@RestController
@NoArgsConstructor
public class PaypalRestClient {

    private static Logger log = LoggerFactory.getLogger(PaypalRestClient.class);

    private static RestClient paypalClient;
    private static String clientId;
    private static String clientSecret;

    public PaypalRestClient(KvpRepository kvpRepository) {
        PaypalRestClient.build(kvpRepository);
    }

    public static void build(KvpRepository kvpRepository) {

        if (clientId != null && clientSecret != null) {
            return;
        }

        Optional<Kvp> opt1 = kvpRepository.findByName("PAYPAL_SB_CLIENT_ID");
        Optional<Kvp> opt2 = kvpRepository
                .findByName("PAYPAL_SB_CLIENT_SECRET");

        if (!opt1.isPresent() || !opt2.isPresent()) {
            return;
        }

        clientId = opt1.get().getValue();
        clientSecret = opt2.get().getValue();
    }

    public PaypalRestClient createConnection() {
        return createConnection(clientId, clientSecret);
    }

    public PaypalRestClient createConnection(final String clientId,
            final String clientSecret) {
        paypalClient = RestClient.builder()
                .baseUrl("https://api-m.sandbox.paypal.com").build();

        final String bytes = Base64.encode(clientId + ":" + clientSecret)
                .toString();

        ResponseEntity<String> result = paypalClient.post()
                .uri("/v1/oauth2/token")
                .header("Authorization", "Basic " + bytes)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body("grant_type=client_credentials").retrieve()
                .toEntity(String.class);

        JSONObject jsonObject = new JSONObject(result.getBody());

        String bearerToken = jsonObject.getString("access_token");

        paypalClient = RestClient.builder()
                .baseUrl("https://api-m.sandbox.paypal.com")
                .defaultHeader("Accept", "application/json")
                .defaultHeader("Content-Type", "application/json")
                .defaultHeader("Prefer", "return=representation")
                .defaultHeader("Authorization", "Bearer " + bearerToken)
                .build();

        return this;
    }

    public void createProduct(Product product) {

    }

    public List<Product> getProducts() {
        ResponseSpec response = paypalClient.get().uri("/v1/catalogs/products")
                .retrieve();

        JSONObject responseObject = new JSONObject(
                response.toEntity(String.class).getBody());

        JSONArray responseArray = responseObject.getJSONArray("products");

        List<Product> products = new ArrayList<Product>();
        ObjectMapper mapper = new ObjectMapper().configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        for (Object jo : responseArray) {
            log.info(jo.toString());
            try {
                products.add(Product.fromDto(
                        mapper.readValue(jo.toString(), ProductDto.class)));
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return products;
    }
}
