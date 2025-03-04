package com.deneth.management_app.service.impl;

import com.deneth.management_app.dto.request.ItemRequestDto;
import com.deneth.management_app.dto.response.ItemResponseDto;
import com.deneth.management_app.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    @Override
    public void update(ItemRequestDto dto, String itemId) {

    }

    @Override
    public void delete(String itemId) {

    }

    @Override
    public ItemResponseDto findById(String itemId) {
        return null;
    }
}
