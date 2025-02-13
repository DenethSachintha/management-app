package com.deneth.E_Commerce_App.dto.response.Paginate;

import com.deneth.E_Commerce_App.dto.response.CustomerResponseDto;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPaginatedDto {
    private long count;
    private List<CustomerResponseDto> dataList;
}
