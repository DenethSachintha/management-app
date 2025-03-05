package com.deneth.management_app.dto.response.Paginate;

import com.deneth.management_app.dto.response.OrderResponseDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderPaginateDto {
    private long count;
    private List<OrderResponseDto> dataList;
}
