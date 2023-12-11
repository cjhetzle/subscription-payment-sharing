package com.cjhetzle.hsb.repository;

import com.cjhetzle.hsb.entity.Product;
import java.util.List;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ListCrudRepository<Product, Integer>,
        ListPagingAndSortingRepository<Product, Integer> {

    List<Product> findAllByName(String name);

}
