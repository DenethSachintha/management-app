package com.deneth.management_app.service;

import com.deneth.management_app.dto.request.ItemRequestDto;
import com.deneth.management_app.dto.response.ItemResponseDto;

public interface ItemService {
    public void update(ItemRequestDto dto, String itemId);
    public void delete(String itemId);
    public ItemResponseDto findById(String itemId);
}