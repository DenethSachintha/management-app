package com.deneth.management_app.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

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
    private String name;

    @Column(length = 300, nullable = false)
    private String description;

    @Column(nullable = false)
    private double unitPrice;

    @Column(nullable = false)
    private int qtyOnHand;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "product_images",
            joinColumns = @JoinColumn(name = "product_id")
    )
    @Column(name = "image_base64",columnDefinition = "TEXT")
    private List<String> images;

}
