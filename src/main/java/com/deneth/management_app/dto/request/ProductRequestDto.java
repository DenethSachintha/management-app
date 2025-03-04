package com.deneth.management_app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {
    private String description;
    private double unitPrice;
    private int qtyOnHand;
}
// do we neeed to insert q when post