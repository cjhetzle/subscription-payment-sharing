package com.cjhetzle.hsb.repository;

import com.cjhetzle.hsb.entity.Kvp;
import java.util.Optional;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KvpRepository
        extends ListCrudRepository<Kvp, Integer>,
        ListPagingAndSortingRepository<Kvp, Integer> {

    Optional<Kvp> findByName(String name);

}
