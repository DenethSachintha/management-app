package com.deneth.management_app.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProductResponseDto {
    private String id;
    private String description;
    private double unitPrice;
    private int qtyOnHand;
}
