package com.deneth.management_app.repository;

import com.deneth.management_app.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CustomerRepo extends JpaRepository<Customer,String> {
    @Query(
            value = "SELECT * FROM customer WHERE name LIKE %?1% OR address LIKE %?1%",
            nativeQuery = true
    )
    public Page<Customer> search(
            String searchText, Pageable pageable
    );
    @Query(
            value = "SELECT COUNT(*) FROM customer WHERE name LIKE %?1% OR address LIKE %?1%",
            nativeQuery = true
    )
    public Long searchCount(
            String searchText
    );

}
