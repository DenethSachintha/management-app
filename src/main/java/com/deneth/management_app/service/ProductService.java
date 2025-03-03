package com.deneth.management_app.service;

import com.deneth.management_app.dto.request.ProductRequestDto;
import com.deneth.management_app.dto.response.Paginate.ProductPaginatedDto;
import com.deneth.management_app.dto.response.ProductResponseDto;

public interface ProductService {
    public ProductResponseDto createProduct(ProductRequestDto dto);
    public void updateProduct(ProductRequestDto dto, String id);
    public void deleteProduct(String id);
    public void manageQtyOnHand(String id, int qty);
    public ProductResponseDto getProduct(String id);
    public ProductPaginatedDto search(
            String searchText, int page, int size
    );
}
