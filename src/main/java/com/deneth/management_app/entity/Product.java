package com.deneth.management_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "product")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @Column(name = "product_id", nullable = false)
    private String productId;
    @Column(length = 100, nullable = false)
    private String description;
    @Column(nullable = false)
    private double unitPrice;
    @Column(nullable = false)
    private int qtyOnHand;
}
