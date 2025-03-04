package com.deneth.management_app.service.impl;

import com.deneth.management_app.dto.request.OrderRequestDto;
import com.deneth.management_app.dto.response.OrderResponseDto;
import com.deneth.management_app.dto.response.Paginate.OrderPaginateDto;
import com.deneth.management_app.entity.Item;
import com.deneth.management_app.entity.Order;
import com.deneth.management_app.repository.OrderRepo;
import com.deneth.management_app.repository.ProductRepo;
import com.deneth.management_app.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;
@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;

    @Override
    public void create(OrderRequestDto dto) {
        String orderId = UUID.randomUUID().toString();

        Order order = Order.builder()
                .orderId(orderId)
                .date(new Date())
                .nett(dto.getNett())
                .build();

        dto.getItems().forEach(itemDto -> {
            Item item = Item.builder()
                    .id(UUID.randomUUID().toString())
                    .qty(itemDto.getQty())
                    .order(order)
                    .build();
            order.addItem(item);
        });

        orderRepo.save(order);
    }

    @Override
    public void update(OrderRequestDto dto, String orderId) {

    }

    @Override
    public void delete(String orderId) {

    }

    @Override
    public OrderResponseDto findById(String orderId) {
        return null;
    }

    @Override
    public OrderPaginateDto search(String searchText, int page, int size) {
        return null;
    }
}
