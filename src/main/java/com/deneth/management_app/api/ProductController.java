package com.deneth.management_app.api;

import com.deneth.management_app.dto.request.ProductRequestDto;
import com.deneth.management_app.dto.response.ProductResponseDto;
import com.deneth.management_app.service.ProductService;
import com.deneth.management_app.util.StandardResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    public ResponseEntity<StandardResponseDto> create(@RequestBody ProductRequestDto dto) {
        ProductResponseDto data = service.createProduct(dto);
        return new ResponseEntity<>(
                new StandardResponseDto(201, "Product created", data),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardResponseDto> update(@RequestBody ProductRequestDto dto, @PathVariable("id") String productId) {
        service.updateProduct(dto, productId);
        return new ResponseEntity<>(
                new StandardResponseDto(201, "Product updated", null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponseDto> findById(@PathVariable("id") String productId) {
        return new ResponseEntity<>(
                new StandardResponseDto(200, "product data", service.getProduct(productId)),
                HttpStatus.OK
        );
    }

    @GetMapping("/search")
    public ResponseEntity<StandardResponseDto> search(
            @RequestParam(defaultValue = "", required = false) String searchText,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int size
    ) {
        return new ResponseEntity<>(
                new StandardResponseDto(200, "product list", service.search(searchText, page, size)),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponseDto> delete(@PathVariable("id") String productId) {
        service.deleteProduct(productId);
        return new ResponseEntity<>(
                new StandardResponseDto(204, "product deleted", null),
                HttpStatus.NOT_FOUND
        );
    }

    @PutMapping("change-qty/{id}")
    public ResponseEntity<StandardResponseDto> update(
            @PathVariable("id") String productId,
                    @RequestParam(defaultValue = "0", required = false) Integer qty

    ) {
        int quantity = (qty != null) ? qty : 0;
        service.manageQtyOnHand(productId, quantity);

        return new ResponseEntity<>(
                new StandardResponseDto(201, "qty updated", null),
                HttpStatus.CREATED
        );
    }
}