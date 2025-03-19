package com.deneth.management_app.dto.response;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProductResponseDto {
    private String id;
    private String name;
    private String description;
    private double unitPrice;
    private int qtyOnHand;
    private List<String> images;

}
