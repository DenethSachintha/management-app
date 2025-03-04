package com.deneth.management_app.api;

import com.deneth.management_app.dto.request.OrderRequestDto;
import com.deneth.management_app.service.OrderService;
import com.deneth.management_app.util.StandardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders") // 🔹 Updated endpoint for orders
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<StandardResponseDto> create(@RequestBody OrderRequestDto dto) {
        orderService.create(dto);
        return new ResponseEntity<>(
                new StandardResponseDto(201, "Order created successfully", null),
                HttpStatus.CREATED
        );
    }
}
