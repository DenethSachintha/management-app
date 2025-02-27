package com.deneth.management_app.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CustomerResponseDto {
    private String id;
    private String name;
    private String address;
    private double salary;
    private boolean status;
}
