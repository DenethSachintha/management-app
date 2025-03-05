package com.deneth.management_app.api;

import com.deneth.management_app.dto.request.OrderRequestDto;
import com.deneth.management_app.dto.response.OrderResponseDto;
import com.deneth.management_app.service.OrderService;
import com.deneth.management_app.util.StandardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders") // 🔹 Updated endpoint for orders
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<StandardResponseDto> create(@RequestBody OrderRequestDto dto) {
        OrderResponseDto data = orderService.create(dto);
        return new ResponseEntity<>(
                new StandardResponseDto(201, "Order created successfully", data),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardResponseDto> update(@RequestBody OrderRequestDto dto, @PathVariable("id") String orderId) {
        OrderResponseDto data = orderService.update(dto, orderId);
        return new ResponseEntity<>(
                new StandardResponseDto(201, "Product updated", data),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponseDto> delete(@PathVariable("id") String id) {
        orderService.delete(id);
        return new ResponseEntity<>(
                new StandardResponseDto(204, "Order deleted", null),
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponseDto> findById(@PathVariable("id") String id) {
        OrderResponseDto orderResponse = orderService.findById(id);
        return new ResponseEntity<>(
                new StandardResponseDto(200, "Order data", orderResponse),
                HttpStatus.OK
        );
    }

}
