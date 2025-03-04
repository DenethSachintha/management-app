package com.deneth.management_app.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "item")
public class Item {
    @Id
    @Column(name = "item_id", unique = true, nullable = false)
    private String id;

    private int qty;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}
