package com.deneth.management_app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "customer")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    @Id
    @Column(name = "customer_id",
            nullable = false)
    private String customerId;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 100, nullable = false)
    private String address;
    @Column(nullable = false)
    private double salary;
    @Column(columnDefinition = "TINYINT")
    private boolean status;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        if (orders == null) {
            orders = new ArrayList<>();
        }
        return orders;
    }

    public void addOrder(Order order) {
        getOrders().add(order);
        order.setCustomer(this);
    }
}
