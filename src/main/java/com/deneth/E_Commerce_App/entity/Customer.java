package com.deneth.E_Commerce_App.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

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
}
