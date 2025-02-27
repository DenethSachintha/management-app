package com.deneth.management_app.service;


import com.deneth.management_app.dto.request.CustomerRequestDto;
import com.deneth.management_app.dto.response.CustomerResponseDto;
import com.deneth.management_app.dto.response.Paginate.CustomerPaginatedDto;

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
