package com.deneth.management_app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "orders") // Renamed to "orders" to avoid MySQL conflict
public class Order {
    @Id
    @Column(name = "order_id", unique = true, nullable = false)
    private String orderId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(nullable = false)
    private double nett;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
        item.setOrder(this);
    }
}
