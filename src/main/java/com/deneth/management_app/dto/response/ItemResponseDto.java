package com.deneth.management_app.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ItemResponseDto {
    private String itemId;
    private int qty;
}