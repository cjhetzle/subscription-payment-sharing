package com.cjhetzle.hsb.rest;

import com.cjhetzle.hsb.entity.Kvp;
import com.cjhetzle.hsb.entity.Product;
import com.cjhetzle.hsb.repository.KvpRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;


@SpringBootTest
public class PaypalRestClientTest {

    @Autowired
    KvpRepository authRepository;
    @Autowired
    static Environment env;

    private static Kvp auth1;
    private static Kvp auth2;
    @Value("${cjhetz.paypal.clientid}")
    private String clientId;
    @Value("${cjhetz.paypal.clientsecret}")
    private String clientSecret;
    private static PaypalRestClient restClient;

    @BeforeEach
    void init() {

        if (restClient == null) {
            auth1 = new Kvp("PAYPAL_SB_CLIENT_ID",
                    clientId);

            auth2 = new Kvp("PAYPAL_SB_CLIENT_SECRET", clientSecret);

            authRepository.save(auth1);
            authRepository.save(auth2);

            clientId = authRepository.findByName("PAYPAL_SB_CLIENT_ID").get()
                    .getValue();

            clientSecret = authRepository.findByName("PAYPAL_SB_CLIENT_SECRET")
                    .get().getValue();

            restClient = new PaypalRestClient().createConnection(clientId,
                    clientSecret);
        }
    }

    @Test
    void testGetProducts() {
        List<Product> products = restClient.getProducts();

        System.out.println(products.toString());
    }
}
