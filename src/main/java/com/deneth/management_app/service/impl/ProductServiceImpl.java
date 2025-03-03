package com.deneth.management_app.service.impl;

import com.deneth.management_app.dto.request.ProductRequestDto;
import com.deneth.management_app.dto.response.Paginate.ProductPaginatedDto;
import com.deneth.management_app.dto.response.ProductResponseDto;
import com.deneth.management_app.entity.Product;
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
        String id = UUID.randomUUID().toString();
        repo.save(toProduct(dto, id));
        return getProduct(id);
    }

    @Override
    public void updateProduct(ProductRequestDto dto, String id) {
        Optional<Product> selectedProduct =
                repo.findById(id);
        if(selectedProduct.isEmpty()){
            throw new RuntimeException("Product Not Found"); // this must be an entry not found exception
        }
        selectedProduct.get().setDescription(dto.getDescription());
        selectedProduct.get().setUnitPrice(dto.getUnitPrice());
        selectedProduct.get().setQtyOnHand(dto.getQtyOnHand());
        repo.save(selectedProduct.get());
    }

    @Override
    public void deleteProduct(String id) {
        repo.deleteById(id);
    }

    @Override
    public void manageQtyOnHand(String id, int qty) {
        Optional<Product> selectedProduct = repo.findById(id);
        if(selectedProduct.isEmpty()){
            throw new RuntimeException("selected Product Not Found"); // this must be an entry not found exception
        }
        selectedProduct.get()
                .setQtyOnHand(qty);
    }

    @Override
    public ProductResponseDto getProduct(String id) {
        Optional<Product> selectedProduct = repo.findById(id);
        if(selectedProduct.isEmpty()){
            throw new RuntimeException("selected Product Not Found"); // this must be an entry not found exception
        }
        return toProductResponseDto(
                selectedProduct.get()
        );
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
    private Product toProduct(ProductRequestDto dto, String id
    ){
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
