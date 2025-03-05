package com.deneth.management_app.repository;

import com.deneth.management_app.entity.Item;
import com.deneth.management_app.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OrderRepo extends JpaRepository<Order, String> {
    @Query("SELECT o FROM orders o JOIN FETCH o.items WHERE o.orderId = :orderId")
    Optional<Order> findByIdWithItems(@Param("orderId") String orderId);

}
