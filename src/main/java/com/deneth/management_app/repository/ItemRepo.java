package com.deneth.management_app.repository;

import com.deneth.management_app.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, String> {
}
