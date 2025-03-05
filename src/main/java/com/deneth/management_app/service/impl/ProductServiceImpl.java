package com.deneth.management_app.service.impl;

import com.deneth.management_app.dto.request.ProductRequestDto;
import com.deneth.management_app.dto.response.Paginate.ProductPaginatedDto;
import com.deneth.management_app.dto.response.ProductResponseDto;
import com.deneth.management_app.entity.Product;
import com.deneth.management_app.exception.EntryNotFoundException;
import com.deneth.management_app.repository.ProductRepo;
import com.deneth.management_app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;
@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo repo;

    @Override
    public ProductResponseDto createProduct(ProductRequestDto dto) {
        Product product = toProduct(dto);

        try {
            repo.save(product);
            return toProductResponseDto(product);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create product", e);
        }
    }

    @Override
    public void updateProduct(ProductRequestDto dto, String id) {
        Product selectedProduct = repo.findById(id)
                .orElseThrow(() -> new EntryNotFoundException("Product Not Found"));

        selectedProduct.setDescription(dto.getDescription());
        selectedProduct.setUnitPrice(dto.getUnitPrice());
        selectedProduct.setQtyOnHand(dto.getQtyOnHand());
        repo.save(selectedProduct);
    }

    @Override
    public void deleteProduct(String id) {
        repo.deleteById(id);
    }

    @Override
    public void manageQtyOnHand(String id, int qty) {
        Product selectedProduct = repo.findById(id)
                .orElseThrow(() -> new EntryNotFoundException("Selected Product Not Found"));

        selectedProduct.setQtyOnHand(qty);
    }

    // Updated method with EntryNotFoundException and orElseThrow
    @Override
    public ProductResponseDto getProduct(String id) {
        Product selectedProduct = repo.findById(id)
                .orElseThrow(() -> new EntryNotFoundException("Selected Product Not Found"));

        return toProductResponseDto(selectedProduct);
    }

    @Override
    public ProductPaginatedDto search(String searchText, int page, int size) {
        return ProductPaginatedDto
                .builder()
                .dataList(
                        repo.search(
                                        searchText,
                                        PageRequest.of(
                                                page,size
                                        )
                                ).map(this::toProductResponseDto)
                                .stream().toList()
                )
                .count(
                        repo.searchCount(searchText)
                ).build();
    }
    private Product toProduct(ProductRequestDto dto
    ){
        String id = UUID.randomUUID().toString();
        return  Product.builder()
                .productId(id)
                .description(dto.getDescription())
                .unitPrice(dto.getUnitPrice())
                .qtyOnHand(dto.getQtyOnHand())
                .build();
    }
    private ProductResponseDto toProductResponseDto(
            Product product
    ){
        return product==null?null:  ProductResponseDto.
                builder()
                .id(product.getProductId())
                .description(product.getDescription())
                .unitPrice(product.getUnitPrice())
                .qtyOnHand(product.getQtyOnHand())
                .build();
    }
}
