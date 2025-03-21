package com.deneth.management_app.dto.response.Paginate;

import com.deneth.management_app.dto.response.ProductResponseDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductPaginatedDto {
    private long count;
    private List<ProductResponseDto> dataList;
}
