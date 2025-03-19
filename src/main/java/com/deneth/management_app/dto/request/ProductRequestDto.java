package com.deneth.management_app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {
    private String description;
    private double unitPrice;
    private int qtyOnHand;

    private String name;
    private List<String> images;
}
