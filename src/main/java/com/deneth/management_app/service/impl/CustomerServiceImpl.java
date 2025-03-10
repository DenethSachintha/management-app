package com.deneth.management_app.service.impl;

import com.deneth.management_app.dto.request.CustomerRequestDto;
import com.deneth.management_app.dto.response.CustomerResponseDto;
import com.deneth.management_app.dto.response.Paginate.CustomerPaginatedDto;
import com.deneth.management_app.entity.Customer;
import com.deneth.management_app.entity.Product;
import com.deneth.management_app.exception.EntryNotFoundException;
import com.deneth.management_app.repository.CustomerRepo;
import com.deneth.management_app.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class CustomerServiceImpl
        implements CustomerService {

    private final CustomerRepo repo;

    @Override
    public CustomerResponseDto createCustomer(CustomerRequestDto dto) {
        Customer customer = toCustomer(dto);
        try {
            repo.save(customer);
            return toCustomerResponseDto(customer);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create product", e);
        }
    }

    @Override
    public CustomerResponseDto updateCustomer(CustomerRequestDto dto, String id) {
        Customer selectedCustomer = repo.findById(id)
                .orElseThrow(() -> new EntryNotFoundException("Customer Not Found"));
        selectedCustomer.setName(dto.getName());
        selectedCustomer.setAddress(dto.getAddress());
        selectedCustomer.setSalary(dto.getSalary());
        try {
            repo.save(selectedCustomer);
            return toCustomerResponseDto(selectedCustomer);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create product", e);
        }
    }
    @Override
    public void deleteCustomer(String id) {
        repo.deleteById(id);
    }

    @Override
    public CustomerResponseDto getCustomer(String id) {
        Customer selectedCustomer = repo.findById(id)
                .orElseThrow(() -> new EntryNotFoundException("Customer Not Found"));

        return toCustomerResponseDto(selectedCustomer);
    }

    @Override
    public void manageStatus(String id) {
        Customer selectedCustomer = repo.findById(id)
                .orElseThrow(() -> new EntryNotFoundException("Customer Not Found"));

        selectedCustomer.setStatus(!selectedCustomer.isStatus());
    }

    @Override
    public CustomerPaginatedDto search(String searchText, int page, int size) {
        return CustomerPaginatedDto
                .builder()
                .dataList(
                        repo.search(
                                        searchText,
                                        PageRequest.of(
                                                page,size
                                        )
                                ).map(this::toCustomerResponseDto)
                                .stream().toList()
                )
                .count(
                        repo.searchCount(searchText)
                ).build();
    }

    private Customer toCustomer(
            CustomerRequestDto dto
    ){
        return  Customer.builder()
                .customerId(
                        UUID.randomUUID().toString())
                .name(dto.getName())
                .address(dto.getAddress())
                .salary(dto.getSalary())
                .status(true).build();
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
