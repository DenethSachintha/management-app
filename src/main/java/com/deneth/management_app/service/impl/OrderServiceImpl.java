package com.deneth.management_app.service.impl;

import com.deneth.management_app.dto.request.ItemRequestDto;
import com.deneth.management_app.dto.request.OrderRequestDto;
import com.deneth.management_app.dto.response.CustomerResponseDto;
import com.deneth.management_app.dto.response.ItemResponseDto;
import com.deneth.management_app.dto.response.OrderResponseDto;
import com.deneth.management_app.dto.response.Paginate.OrderPaginateDto;
import com.deneth.management_app.entity.Customer;
import com.deneth.management_app.entity.Item;
import com.deneth.management_app.entity.Order;
import com.deneth.management_app.exception.EntryNotFoundException;
import com.deneth.management_app.repository.CustomerRepo;
import com.deneth.management_app.repository.OrderRepo;
import com.deneth.management_app.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final CustomerRepo customerRepo;

    public OrderResponseDto create(OrderRequestDto dto) {
        Order order = toOrder(dto);
        try {
            orderRepo.save(order);
            return toOrderResponseDto(order);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create product", e);
        }
    }

    @Override
    public OrderResponseDto update(OrderRequestDto dto, String orderId) {

        Order order = orderRepo.findById(orderId)
                        .orElseThrow(() -> new EntryNotFoundException("Order Not Found"));
        Customer customer = customerRepo.findById(dto.getCustomerId())
                .orElseThrow(() -> new EntryNotFoundException("Customer Not Found"));
        order.setNett(dto.getNett());
        order.setCustomer(customer);
        order.getItems().clear();
        for (ItemRequestDto itemDto : dto.getItems()) {
            Item item = new Item();
            item.setId(itemDto.getId());
            item.setUnitPrice(itemDto.getUnitPrice());
            item.setQty(itemDto.getQty());
            item.setOrder(order);
            order.getItems().add(item);
        }

        try {
            orderRepo.save(order);
            return toOrderResponseDto(order);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create product", e);
        }
    }

    @Override
    public void delete(String orderId) {
        orderRepo.deleteById(orderId);
    }

    @Override
    public OrderResponseDto findById(String orderId) {
        Order order = orderRepo.findByIdWithItems(orderId)
                .orElseThrow(() -> new EntryNotFoundException("Order Not Found"));
        return toOrderResponseDto(order);
    }


    @Override
    public OrderPaginateDto search(String searchText, int page, int size) {
        return null;
    }

    private OrderResponseDto toOrderResponseDto(Order order) {
        return OrderResponseDto.builder()
                .orderId(order.getOrderId())
                .date(order.getDate())
                .nett(order.getNett())
                .customer(toCustomerResponseDto(order.getCustomer()))
                .items(order.getItems().stream()
                        .map(this::toItemResponseDto)
                        .collect(Collectors.toList()))
                .build();
    }

    private ItemResponseDto toItemResponseDto(Item item) {
        return ItemResponseDto.builder()
                .itemId(item.getId())
                .unitPrice(item.getUnitPrice())
                .qty(item.getQty())
                .build();
    }

    private Order toOrder(OrderRequestDto dto) {
        String orderId = UUID.randomUUID().toString();
        Customer customer = customerRepo.findById(dto.getCustomerId())
                .orElseThrow(() -> new EntryNotFoundException("Customer Not Found"));

        Order order = Order.builder()
                .orderId(orderId)
                .date(new Date())
                .nett(dto.getNett())
                .customer(customer) // Set the customer
                .build();

        dto.getItems().forEach(itemDto -> {
            Item item = Item.builder()
                    .id(itemDto.getId())
                    .unitPrice(itemDto.getUnitPrice())
                    .qty(itemDto.getQty())
                    .order(order)
                    .build();
            order.addItem(item);
        });
        return order;
    }
    private CustomerResponseDto toCustomerResponseDto(
            Customer c
    ){
        return c==null?null:  CustomerResponseDto.
                builder()
                .id(c.getCustomerId())
                .name(c.getName())
                .address(c.getAddress())
                .salary(c.getSalary())
                .status(c.isStatus()).build();
    }
}
