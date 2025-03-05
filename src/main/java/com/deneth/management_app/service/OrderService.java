package com.deneth.management_app.service;

import com.deneth.management_app.dto.request.OrderRequestDto;
import com.deneth.management_app.dto.response.OrderResponseDto;
import com.deneth.management_app.dto.response.Paginate.OrderPaginateDto;

public interface OrderService {
    public OrderResponseDto create(OrderRequestDto dto);
    public OrderResponseDto update(OrderRequestDto dto, String orderId);
    public void delete(String orderId);
    public OrderResponseDto findById(String orderId);
    public OrderPaginateDto search(String searchText, int page, int size);
}