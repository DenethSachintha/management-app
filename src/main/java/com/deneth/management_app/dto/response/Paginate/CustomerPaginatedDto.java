package com.deneth.management_app.dto.response.Paginate;

import com.deneth.management_app.dto.response.CustomerResponseDto;
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
