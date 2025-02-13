package com.deneth.E_Commerce_App.service;


import com.deneth.E_Commerce_App.dto.request.CustomerRequestDto;
import com.deneth.E_Commerce_App.dto.response.CustomerResponseDto;
import com.deneth.E_Commerce_App.dto.response.Paginate.CustomerPaginatedDto;

public interface CustomerService {
    public void createCustomer(CustomerRequestDto dto);
    public void updateCustomer(CustomerRequestDto dto, String id);
    public void deleteCustomer(String id);
    public CustomerResponseDto getCustomer(String id);
    public void manageStatus(String id);
    public CustomerPaginatedDto search(
            String searchText, int page, int size
    );
}
