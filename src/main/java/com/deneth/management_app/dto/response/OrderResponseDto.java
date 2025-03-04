package com.deneth.management_app.dto.response;

import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OrderResponseDto {
    private String orderId;
    private Date date;
    private double nett;
    private List<ItemResponseDto> items;
}