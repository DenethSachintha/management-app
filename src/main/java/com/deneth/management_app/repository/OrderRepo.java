package com.deneth.management_app.repository;

import com.deneth.management_app.entity.Item;
import com.deneth.management_app.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, String> {
}
